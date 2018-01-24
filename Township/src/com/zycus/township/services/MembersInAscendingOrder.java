package com.zycus.township.services;

import java.util.Comparator;

import com.zycus.township.entities.Owner;

public class MembersInAscendingOrder implements Comparator{

		public int compare(Object arg0,Object arg1){
			String key1=((Owner)arg0).getOwnerName();
			String key2=((Owner)arg1).getOwnerName();
			
			return key1.compareTo(key2);
		}
	}


