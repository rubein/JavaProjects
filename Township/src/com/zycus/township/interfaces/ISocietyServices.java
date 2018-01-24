package com.zycus.township.interfaces;

import com.zycus.township.entities.Flat;

public interface ISocietyServices {
	public Flat getFlat(String wingNo,int floorNo,int flatNo);
	public String getFlatOwnerName(String wingNo,int floorNo, int flatNo);
	public Flat getFlatOwnerDetails(String ownerName);
	public void getAllFlatOwners();
}
