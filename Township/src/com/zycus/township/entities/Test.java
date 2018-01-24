package com.zycus.township.entities;

import java.util.ArrayList;

import com.zycus.township.services.AllServices;

public class Test {

	public static void main(String[] args) {
		Flat flat0=null;
		ArrayList<Flat> flatsOnFloor = new ArrayList<Flat>();
		AllServices allServices = AllServices.getInstance();
		allServices.createTownship();
		System.out.println("township created");
		System.out.println(allServices);
		System.out.println("Get flat details"+allServices.getFlat("W1", 1, 1));
		Flat flat=allServices.getFlat("W1", 1, 1);
		Flat flat1=allServices.getFlat("W1", 1, 2);
		Flat flat2=allServices.getFlat("W1", 1, 3);
		Flat flat3=allServices.getFlat("W1", 2, 1);
		Flat flat4=allServices.getFlat("W1", 3, 1);
		Owner owner=new Owner("rubein");
		Owner owner1=new Owner("agni");
		Owner owner2=new Owner("Gautam");
		Owner owner3=new Owner("Harsh");
		Owner owner4=new Owner("Saurav");
		System.err.println("Owner created");
		
		flat.setOwner(owner);
		flat1.setOwner(owner1);
		flat2.setOwner(owner2);
		flat3.setOwner(owner3);
		flat4.setOwner(owner4);
		
		allServices.changeForSaleToSold("W1", 1, 1, owner);
		allServices.changeForSaleToSold("W1", 1, 2, owner1);
		allServices.changeForSaleToSold("W1", 1, 3, owner2);
		allServices.changeForSaleToSold("W1", 2, 1, owner3);
		allServices.changeForSaleToSold("W1", 3, 1, owner4);
		
		System.out.println("flat owner of flat 1 is :"+flat);
		
		System.out.println(allServices.getFlatOwnerDetails("rubein"));
		
		System.out.println("all flat owners list is called ");
		allServices.getAllFlatOwners();
								
	}
}
