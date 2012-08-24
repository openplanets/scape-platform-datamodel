package eu.scapeproject.model.util;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public abstract class CopyUtil {
    @SuppressWarnings("unchecked")
    public static <T> T deepCopy(Class<?> type, T obj) {
        try {
            T copy = null;
            for (Constructor<?> c : type.getDeclaredConstructors()) {
                if (c.getParameterTypes().length == 0 && Modifier.isPrivate(c.getModifiers())) {
                    c.setAccessible(true);
                    copy = (T) c.newInstance();
                }
            }
            for (Field f : obj.getClass().getDeclaredFields()) {
                f.setAccessible(true);
                if (f.getType() == String.class) {
                    String val = (String) f.get(obj);
                    f.set(copy, val);
                } else if (f.getType() == int.class) {
                    if (f.get(obj) != null) {
                        f.set(copy, f.get(obj));
                    }
                } else if (f.getType() == long.class) {
                    if (f.get(obj) != null) {
                        f.set(copy, f.get(obj));
                    }
                } else if (f.getType() == Date.class) {
                    f.set(copy, new Date(((Date) f.get(obj)).getTime()));
                } else if (f.getType() == List.class) {
                    List<Object> data = new ArrayList<Object>();
                    List<Object> original = (List<Object>) f.get(obj);
                    if (original != null) {
                        for (Object e : original) {
                            data.add(deepCopy(Object.class, e));
                        }
                    }
                    f.set(copy, data);

                } else {
                    if (f.get(obj) != null) {
                        System.out.println("recursing into " + f.getName() + " with type " + f.getType().getName());
                        f.set(copy, deepCopy(f.getType(), f.get(obj)));
                    }
                }
            }
            return copy;
        } catch (Exception e) {
            throw new RuntimeException("Error while deep copying objects");
        }
    }
}
