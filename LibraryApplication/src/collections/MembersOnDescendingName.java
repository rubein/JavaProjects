package collections;

import java.util.Comparator;

public class MembersOnDescendingName implements Comparator{
	public int compare(Object arg0,Object arg1){
		String key1=((Member)arg0).getMemberNm();
		String key2=((Member)arg1).getMemberNm();
		
		return key2.compareTo(key1);
	}

}
