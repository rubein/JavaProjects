package collections;

import java.util.Comparator;

public class MemberSortStrategyFactory {
	
	public Comparator getSortStrategy(String order){
		if(order.equals("ascending names")){
			return new MembersOnAscendingName();
		} else if(order.equals("descending names")){
			return new MembersOnDescendingName();
		}
		else return null;
		}
	}

