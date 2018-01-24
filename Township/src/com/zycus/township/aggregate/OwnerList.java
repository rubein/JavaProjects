package com.zycus.township.aggregate;
import com.zycus.township.entities.Owner;

public class OwnerList {
	
	private static OwnerList ownerList;
	Owner owner;

	private OwnerList(){
		ownerList=null;
	}
	
	public static OwnerList getInstance(){
		if(ownerList==null){
			return new OwnerList();
		}
		return ownerList;
	}
}