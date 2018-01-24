package com.zycus.township.interfaces;

import com.zycus.township.entities.Flat;
import com.zycus.township.entities.Owner;

public interface IBuilderServices {
	public String getFlatStatus(String wingNo,int floorNo, int flatNo);
	public void changeForSaleToSold(String wingNo,int floorNo, int flatNo, Owner owner);
	public void changeBlockedToSold(String wingNo,int floorNo, int flatNo, Owner owner);
	public void changeForSaleToBlocked(String wingNo,int floorNo, int flatNo, Owner owner);
	public void changeBlockedToForSale(String wingNo,int floorNo, int flatNo);
	public String getFlatOwnerName(String wingNo,int floorNo, int flatNo);
	public Flat getFlatOwnerDetails(String ownerName);
}
