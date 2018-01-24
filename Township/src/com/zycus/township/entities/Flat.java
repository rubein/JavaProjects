package com.zycus.township.entities;

import java.awt.List;
import java.util.ArrayList;

public class Flat {
	
	private int flatNo;
	private String status;
	private int MaxNoOfFlats;
	
	private Owner owner;
	private Floor floor;
	
	public Flat(int flatNo,Floor floor) {
		super();
		this.flatNo = flatNo;
		this.owner = null;
		this.floor = floor;
		this.status= "ForSale";
	}
	
	public Floor getFloor() {
		return floor;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getFlatNo() {
		return flatNo;
	}

	public Owner getOwner() {
		return owner;
	}

	public void setFlatNo(int flatNo) {
		this.flatNo = flatNo;
	}

	public void setOwner(Owner owner) {
		this.owner = owner;
	}
	
	
//	public int getFlatOwnerDetails(String ownerName){
//		if(this.getOwner().getOwnerName().equalsIgnoreCase(ownerName)){
//			return this.getFlatNo();
//		}else return 0 ;
//	}
//	
	@Override
	public String toString() {
		return "\nFlat [flatNo=" + flatNo + ", owner=" + owner + ", status=" + status + "]";
	};
	

}
