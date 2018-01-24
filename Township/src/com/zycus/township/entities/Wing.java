package com.zycus.township.entities;

import java.util.LinkedList;
import java.util.List;

public class Wing {
	
	private int maxNoOfFloors;
	private String wingNo;
	private List<Floor> floorsInWing;
	private Township township;

	public Wing(String wingNo, int maxNoOfFloors, Township township) {
		this.wingNo = wingNo;
		this.maxNoOfFloors=maxNoOfFloors;
		this.floorsInWing=new LinkedList<Floor>();
		this.township=township;
		this.createFloor();
		
	}
	
	public String getWingNo() {
		return wingNo;
	}

	public List<Floor> getFloorsInWing() {
		return floorsInWing;
	}
	
	
	public Floor searchForFloor(int floorNo){
		for(Floor floor:floorsInWing){
			if(floor.getFloorNo()==floorNo)
				return floor;
		}return null;
	}
	
	public void createFloor(){
		if(maxNoOfFloors==0){
			for(int index=1; index<=maxNoOfFloors;index++){
				Floor floor=new Floor(index);
				floorsInWing.add(floor);
			}
		}
	}
	@Override
	public String toString() {
		return "\nWing [wingNo=" + wingNo + ", floorsInWings=" + floorsInWing
				+ "]";
	}	
	
}
