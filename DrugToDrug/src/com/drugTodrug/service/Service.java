package com.drugTodrug.service;

public class Service {

	public float calculateDDI(int drugA, int drugB){
		float result = drugA*drugB;
		result = (float) Math.sqrt(result);
		return result;
	}
	
	public static void main(String[] args) {
		System.out.println(new Service().calculateDDI(2, 2));
	}

}
