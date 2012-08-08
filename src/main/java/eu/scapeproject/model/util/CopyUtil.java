package eu.scapeproject.model.util;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public abstract class CopyUtil {
    @SuppressWarnings("unchecked")
	public static <T> T deepCopy(Class<?> type, T obj) throws Exception {
        if (type == String.class){
			return (T) new String((String) obj);
        } else if (type == int.class  || type == Integer.class){
        	return (T) (Integer) obj;
        } else if (type == long.class || type == Long.class){
        	return (T) (Long) obj;
        } else if (type == Date.class){
        	return (T) new Date(((Date) obj).getTime());
        } else if (obj instanceof List){
        	List<Object> origList=(List<Object>) obj;
        	if (origList != null){
        		List<Object> newList=new ArrayList<Object>(origList.size());
        		for (Object element:origList){
        			newList.add(deepCopy(element.getClass(), element));
        		}
        		return (T) newList;
        	}
        }
        
        T copy = null;
        for (Constructor<?> c : type.getDeclaredConstructors()) {
            if (c.getParameterTypes().length == 0 && Modifier.isPrivate(c.getModifiers())) {
                c.setAccessible(true);
                copy = (T) c.newInstance();
            }
        }
        for (Field f : obj.getClass().getDeclaredFields()) {
            f.setAccessible(true);
            if (!Modifier.isStatic(f.getModifiers())){
	            Object val=f.get(obj);
	            if (val != null){
	            	f.set(copy,deepCopy(val.getClass(), val));
	            }
            }
        }
        return copy;
    }
}
