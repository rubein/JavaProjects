package com.zycus.township.entities;
import java.util.ArrayList;

public class Owner {
	private String ownerName;
	private Flat flats;

	public Owner(String ownerName) {
		super();
		this.ownerName = ownerName;
	}
	
	public String getOwnerName() {
		return ownerName;
	}
	
	public void setOwnerName(String ownerName){
		this.ownerName=ownerName;
	}
	
	public Flat getFlats() {
		return flats;
	}
	
	
	@Override
	public String toString() {
		return "Owner [ownerName=" + ownerName + ", flats=" + flats + "]";
	}
	
}
