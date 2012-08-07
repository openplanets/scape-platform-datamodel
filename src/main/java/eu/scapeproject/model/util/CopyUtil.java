package eu.scapeproject.model.util;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Member;
import java.lang.reflect.Modifier;
import java.util.ArrayList;

import com.sun.xml.bind.v2.schemagen.xmlschema.List;

public abstract class CopyUtil {
    public static <T> T deepCopy(Class<?> type, T obj) throws Exception {
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
            } else if (f.getType() == List.class) {
                System.out.println("skipping list");
            } else {
                if (f.get(obj) != null){
                    System.out.println("recuring into " + f.getName() + " with type " + f.getType().getName());
                    f.set(copy, deepCopy(f.getType(),f.get(obj)));
                }
            }
        }
        return copy;
    }
}
