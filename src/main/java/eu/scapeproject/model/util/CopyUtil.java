package eu.scapeproject.model.util;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import eu.scapeproject.dto.mets.MetsMetadata;
import eu.scapeproject.dto.mets.MetsTechMD;
import eu.scapeproject.model.Identifier;

public abstract class CopyUtil {
    @SuppressWarnings("unchecked")
    public static <T> T deepCopy(Class<?> type, T obj) {
        if (type == String.class) {
            return (T) new String((String) obj);
        } else if (type == Integer.class || type == int.class) {
            return (T) (Integer) obj;
        } else if (type == Long.class || type == long.class) {
            return (T) (Long) obj;
        } else if (type == Double.class || type == double.class) {
            return (T) (Double) obj;
        } else if (type == Float.class || type == float.class) {
            return (T) (Float) obj;
        } else if (type == Short.class || type == short.class) {
            return (T) (Short) obj;
        } else if (type == Date.class) {
            return (T) new Date(((Date) obj).getTime());
        } else if (obj instanceof List) {
            List<Object> origList = (List<Object>) obj;
            if (origList != null) {
                List<Object> newList = new ArrayList<Object>(origList.size());
                for (Object element : origList) {
                    newList.add(deepCopy(element.getClass(), element));
                }
                return (T) newList;
            }
        }else if (obj instanceof double[]){
            double[] origArr= (double[]) obj;
            double[] newArr = new double[origArr.length];
            for (int i=0;i<origArr.length;i++){
                newArr[i]=origArr[i];
            }
            return (T) newArr;
        }else if (obj instanceof byte[]){
            byte[] origArr= (byte[]) obj;
            byte[] newArr = new byte[origArr.length];
            for (int i=0;i<origArr.length;i++){
                newArr[i]=origArr[i];
            }
            return (T) newArr;
        }else if (obj instanceof Object[]){
            Object[] origArr= (Object[]) obj;
            Object[] newArr = new Object[origArr.length];
            for (int i=0;i<origArr.length;i++){
                newArr[i]=deepCopy(origArr[i].getClass(), origArr[i]);
            }
            return (T) newArr;
        }


        T copy = null;
        if (type.isEnum()){
            return obj;
        }
        for (Constructor<?> c : type.getDeclaredConstructors()) {
            if (c.getParameterTypes().length == 0) {
                if (!c.isAccessible()) {
                    c.setAccessible(true);
                }
                try {
                    copy = (T) c.newInstance();
                } catch (Exception e) {
                    throw new RuntimeException(
                            "Unable to instantiate copied object", e);
                }
            }
        }
        if (copy == null) {
            throw new RuntimeException("Unable to instantaiate copy of type "
                    + type.getName());
        }
        for (Field f : obj.getClass().getDeclaredFields()) {
            f.setAccessible(true);
            if (!Modifier.isStatic(f.getModifiers())) {
                try {
                    Object val = f.get(obj);
                    if (val != null) {
                        f.set(copy, deepCopy(val.getClass(), val));
                    }
                } catch (Exception e) {
                    try {
                        throw new RuntimeException(
                                "Unable to deep copy object of type "
                                        + f.getType().getName() + " and value "
                                        + f.get(obj), e);
                    } catch (Exception e1) {
                        e1.printStackTrace();
                    }
                }
            }
        }
        if (obj instanceof MetsMetadata){
            Field id;
            try {
                id = MetsMetadata.class.getDeclaredField("id");
                id.setAccessible(true);
                id.set(copy, id.get(obj));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return copy;
    }
}
