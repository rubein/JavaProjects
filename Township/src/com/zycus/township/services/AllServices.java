package com.zycus.township.services;
import java.util.Collections;
import java.util.Comparator;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Properties;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane.MaximizeAction;

import com.zycus.township.entities.Flat;
import com.zycus.township.entities.Floor;
import com.zycus.township.entities.Owner;
import com.zycus.township.entities.Township;
import com.zycus.township.entities.Wing;
import com.zycus.township.interfaces.IBuilderServices;
import com.zycus.township.interfaces.ISecurityServices;
import com.zycus.township.interfaces.ISocietyServices;
import com.zycus.township.properties.PropertyDetails;

public class AllServices implements IBuilderServices, ISecurityServices, ISocietyServices,Comparator {
	
	Township township;
	
	
	private static AllServices allServices;
	
	private AllServices(){
		this.createTownship();	
	}
	
	public static AllServices getInstance(){
		if(allServices==null){
			allServices=new AllServices();
		}
		return allServices;
	}
	
	public Flat getFlat(String wingNo,int floorNo,int flatNo){
		return township.searchForFlat(wingNo, floorNo, flatNo);
	}
	
	public String getFlatStatus(String wingNo,int floorNo, int flatNo){
		return getFlat(wingNo, floorNo, flatNo).getStatus();
	}
	
	public void changeForSaleToSold(String wingNo,int floorNo, int flatNo, Owner owner){
		Flat flat=getFlat(wingNo, floorNo, flatNo);
		if(flat.getStatus().equalsIgnoreCase("ForSale")){
			flat.setStatus("sold");
			flat.setOwner(owner);
		}else{
			// throw exception
		}
	}
	
	public void changeBlockedToSold(String wingNo,int floorNo, int flatNo, Owner owner){
		Flat flat=getFlat(wingNo, floorNo, flatNo);
		if(flat.getStatus().equalsIgnoreCase("Blocked")){
			flat.setStatus("sold");
			flat.setOwner(owner);
		}else{
			// throw exception
		}
	}
	
	public void changeForSaleToBlocked(String wingNo,int floorNo, int flatNo, Owner owner){
		Flat flat=getFlat(wingNo, floorNo, flatNo);
		if(flat.getStatus().equalsIgnoreCase("ForSale")){
			flat.setStatus("Blocked");
			flat.setOwner(owner);
		}else{
			// throw exception
		}
	}
	
	public void changeBlockedToForSale(String wingNo,int floorNo, int flatNo){
		Flat flat=getFlat(wingNo, floorNo, flatNo);
		if(flat.getStatus().equalsIgnoreCase("Blocked")){
			flat.setStatus("ForSale");
		}else{
			// throw exception
		}
	}
	
	public String getFlatOwnerName(String wingNo,int floorNo, int flatNo){
		Flat flat=getFlat(wingNo, floorNo, flatNo);
		return flat.getOwner().getOwnerName();
	}
	
	
	
	public void createTownship(){
		PropertyDetails property= PropertyDetails.getInstance();
		int noWings = property.getMaxNoOfWings();
		int maxNoOfFloors=property.getMaxNoOfFloors();
		String townshipName=property.getTownshipName();
		
		township = null;
		township =Township.getInstance();
		
		
		List<Wing> wings = township.getWings();
		String wingExt = "W";
		
		for (int i = 1; i<=noWings; i++) {
			Wing wing = new Wing(wingExt + i, maxNoOfFloors, township);
			List<Floor> floors = wing.getFloorsInWing();
				for (int j = 1; j <= maxNoOfFloors; j++) {
					Floor floor = new Floor(j);
					List<Flat> flats = floor.getFlatsOnFloor();
					for (int k = 1; k <= 3; k++) {						
						Flat flat = new Flat(k, floor);
						flats.add(flat);
					}
					floors.add(floor);
				}
			wings.add(wing);
		}
	}
	
	public void getAllFlatOwners(){
		township.getAllFlatOwners();
	}

	public Flat getFlatOwnerDetails(String ownerName) {
		
		for (Wing wing : township.getWings()) {
			for (Floor floor : wing.getFloorsInWing()) {
				for (Flat flat : floor.getFlatsOnFloor()) {
					if (flat.getOwner().getOwnerName().equals(ownerName)) {
						return flat;
					}

				}
			}
		}
		return null;
	}
	
	public int compare(Object arg0,Object arg1){
		String key1=((Owner)arg0).getOwnerName();
		String key2=((Owner)arg1).getOwnerName();
		return key1.compareTo(key2);
	}
	
	@Override
	public String toString() {
		return "AllServices [township=" + township + "]";
	}
}