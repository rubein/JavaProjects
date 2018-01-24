package com.zycus.township.entities;

import java.util.ArrayList;

public class Floor {

	private int floorNo;
	private int maxNoOfFlats;

	private ArrayList<Flat> flatsOnFloor;
	private Flat flat;
	
	public Floor(int floorNo) {
		super();
		this.floorNo = floorNo;
		flatsOnFloor = new ArrayList<Flat>();
		createFlat();
	}

	public int getFloorNo() {
		return floorNo;
	}

	public ArrayList<Flat> getFlatsOnFloor() {
		return flatsOnFloor;
	}

	public int getMaxNoOfFlats() {
		return maxNoOfFlats;
	}

	public void setMaxNoOfFlats(int maxNoOfFlats) {
		this.maxNoOfFlats = maxNoOfFlats;
	}

	public void setFlatsOnFloor(ArrayList<Flat> flatsOnFloor) {
		this.flatsOnFloor = flatsOnFloor;
	}

	public Flat searchForFlat(int flatNo) {
		for (Flat flat : flatsOnFloor) {
			if (flat.getFlatNo() == flatNo)
				return flat;
		}
		return null;
	}

	private void createFlat() {
		if (flatsOnFloor.size() == 0) {
			for (int index = 1; index <= maxNoOfFlats; index++) {
				String flatNo = "";
				flatNo += flatNo + index;
				Flat flat = new Flat(index, this);
				flatsOnFloor.add(flat);
			}
		}
	}

	

	@Override
	public String toString() {
		return "\nFloor [floorNo=" + floorNo + ", flatsOnFloor=" + flatsOnFloor
				+ "]";
	}
}
