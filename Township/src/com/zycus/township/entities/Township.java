package com.zycus.township.entities;

import java.util.ArrayList;
import java.util.Properties;

public class Township {

	private static String constructionGroupName;
	private static String townshipName;
	private ArrayList<Wing> wings;
	private int maxNoOfWings;
	private static Township township;
	
	private Township( String constructionGroupName, String townshipName){
		this.constructionGroupName=constructionGroupName;
		this.townshipName=townshipName;
		this.createWing();
	}
	
	public static Township getInstance(){
		Properties property=new Properties();
		String consString = property.getProperty("ConstructionGroupName");
		String townshipName = property.getProperty("TownshipName");
		if(township==null){
			township=new Township(consString,townshipName);
		}
			return township;
	}
	
	public String getConstructionGroupName() {
		return constructionGroupName;
	}

	public void setConstructionGroupName(String constructionGroupName) {
		this.constructionGroupName = constructionGroupName;
	}

	public String getTownshipName() {
		return townshipName;
	}

	public void setTownshipName(String townshipName) {
		this.townshipName = townshipName;
	}

	public int getMaxNoOfWings() {
		return maxNoOfWings;
	}

	public void setMaxNoOfWings(int maxNoOfWings) {
		this.maxNoOfWings = maxNoOfWings;
	}

	public ArrayList<Wing> getWings() {
		if(wings ==null)
			wings = new ArrayList<Wing>();
		return wings;
	}

	public Wing searchWing(String wingNo){
		for(Wing wing:wings){
			if(wing.getWingNo().equals(wingNo)){
				return wing;
			}
		}return null;
	}
	
	public Flat searchForFlat(String wingNo,int floorNo,int flatNo){
		Wing wing=searchWing(wingNo);
		if(wing==null){
			System.out.println(" no such wing found ");
		}
		Floor floor=wing.searchForFloor(floorNo);
		if(floor==null){
			System.out.println("no such floor found");
		}
		Flat flat=floor.searchForFlat(flatNo);
		if(flat==null){
			System.out.println("no such flat found");
		}
		return flat;
	}
	
	public void createWing(){
		if(maxNoOfWings==0){
			for(int index=1; index<=maxNoOfWings;index++){
				String wingNo="";
				Wing wing=new Wing("" , index, null);
				wings.add(wing);
			}
		}
	}
	
	public void getAllFlatOwners(){
		for(Wing wing: wings){
			for(Floor floor:wing.getFloorsInWing()){
				for(Flat flat:floor.getFlatsOnFloor()){
					if(flat.getOwner()!=null)
						System.out.println(flat);
				}
			}
		}
			
	}
	@Override
	public String toString() {
		return "Township [wings=" + wings + ", maxNoOfWings=" + maxNoOfWings
				+ "]";
	}
	
	
}
