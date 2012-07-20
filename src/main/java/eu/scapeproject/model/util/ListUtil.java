package eu.scapeproject.model.util;

import java.util.ArrayList;
import java.util.List;

public abstract class ListUtil {
	public static List<String> copyList(List<String> orig) {
		if (orig == null){
			return null;
		}
		List<String> copy=new ArrayList<String>();
		for (String s:orig){
			copy.add(new String(s));
		}
		return copy;
	}
}
