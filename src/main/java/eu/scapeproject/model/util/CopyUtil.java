package eu.scapeproject.model.util;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Member;
import java.lang.reflect.Modifier;

public abstract class CopyUtil {
    public static <T> T deepCopy(Class<T> type, T obj) throws Exception {
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
                System.out.println("copied " + val + " for " + f.getName());
            } else if (f.getType() == int.class) {
                if (f.get(obj) != null) {
                    f.set(copy, f.get(obj));
                }
            }
        }
        return copy;
    }
}
