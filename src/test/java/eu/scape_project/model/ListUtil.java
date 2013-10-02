/*
   Licensed under the Apache License, Version 2.0 (the "License");
   you may not use this file except in compliance with the License.
   You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

   Unless required by applicable law or agreed to in writing, software
   distributed under the License is distributed on an "AS IS" BASIS,
   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
   See the License for the specific language governing permissions and
   limitations under the License.
 */
package eu.scape_project.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
*
* @author frank asseg
*
*/
public abstract class ListUtil {
	public static boolean compareDates(Collection<Date> orig,Collection<Date> cmp){
		if (orig == cmp){
			return true;
		}
		if (orig == null){
			return cmp == null;
		}
		if (orig.size() != cmp.size()){
			return false;
		}
		Iterator<Date> it1=orig.iterator();
		Iterator<Date> it2=cmp.iterator();
		while (it1.hasNext()){
			Date d1=it1.next();
			Date d2=it2.next();
			if (d1.getTime() != d2.getTime()){
				return false;
			}
		}

		return true;
	}

	public static boolean compareFiles(Collection<File> orig,Collection<File> cmp){
		if (orig == cmp){
			return true;
		}
		if (orig == null){
			return cmp == null;
		}
		if (orig.size() != cmp.size()){
			return false;
		}
		Iterator<File> it1=orig.iterator();
		Iterator<File> it2=cmp.iterator();
		while (!it1.hasNext()){
			if (it1.next().equals(it2.next())){
				return false;
			}
		}
		return true;
	}

	public static <T> boolean compareLists(Class<T> type, List<T> list1,List<T> list2){
		List<T> tmp=new LinkedList<T>();
		tmp.addAll(list2);
		for (T element: list1){
			boolean found=false;
			Iterator<T> it=tmp.iterator();
			while (it.hasNext()){
				T e=it.next();
				if (e.equals(element)){
					it.remove();
					found=true;
					continue;
				}
			}
			if (!found){
				return false;
			}
		}
		return tmp.size() == 0;
	}

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