package com.zycus.township.interfaces;

import com.zycus.township.entities.Flat;

public interface ISecurityServices {
	public String getFlatOwnerName(String wingNo,int floorNo, int flatNo);
	public Flat getFlatOwnerDetails(String ownerName);
}
