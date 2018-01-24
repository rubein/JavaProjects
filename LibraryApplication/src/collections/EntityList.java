package collections;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.TreeSet;

import com.zycus.library.aggregates.MemberList;

public class EntityList  {
 
	//private ArrayList entities;
	//private LinkedList entities;
	//private HashSet entities;
	
	private TreeSet entities;
	
	public EntityList(String order){
	//	entities=new ArrayList();
//		entities.ensureCapacity(arg0)
		//entities=new HashSet();
		//entities=new TreeSet(new MembersOnAscendingName());
		MemberSortStrategyFactory factory=new MemberSortStrategyFactory();
		entities=new TreeSet(factory.getSortStrategy(order));
	}
	
	public void addNewMember(Member member){
		//if(entities.contains(member)){
		//	System.out.println("duplicate member");
		//}else
		entities.add(member);
		//System.out.println(entities.getLast());
	}
	
	public void showAllMembers(){
		for (Object object:entities){
			System.out.println(object);
		}
	}
	
	public Member getMember(int memberId){
		//use enhanced for for traversing 
		for(Object object:entities){
			if(object.hashCode()==memberId){
				return (Member) object;
			}
		}return null;
	}	
		//use iterator
		/*Iterator iterator=entities.iterator();
		while(iterator.hasNext()){
			Object object=iterator.next();
			if(object.hashCode()==memberId){
				return (Member) object;
			}
		}*/
		
		//use List iterator
		/*ListIterator lIterate=entities.listIterator(entities.size());
		while(lIterate.hasPrevious()){
			Object object = lIterate.previous();
		if(object.hashCode()==memberId){
			return (Member) object;
			}
		}
		
	}*/
	
//	public void unSubscribeMember(int memberId){
//		System.out.println(getMember(memberId));
//		entities.remove(getMember(memberId));
//	}
	
	public static void main(String[] args) {
		EntityList list=new EntityList("");
		
		Member member1=new Member(100, "aaaa");
		Member member2=new Member(101, "bbbb");
		
		list.addNewMember(member1);
		list.addNewMember(member2);
		
//		Member member3=list.getMember(100);
//		System.out.println(member3);
		Member member3=new Member(102,"xxxx");
		
		list.addNewMember(member3);
		Member member4=new Member(103,"yyyy");
		list.addNewMember(member4);
		
		list.showAllMembers();
		
 	}
}
