package com.zycus.township.factory;

import com.zycus.township.entities.Township;
import com.zycus.township.interfaces.IBuilderServices;

public class TownshipFactory {

private static TownshipFactory townshipFactory;
	
	private Township townshipServices;
	
	private TownshipFactory(){
		townshipServices = townshipServices.getInstance();
	}
	
	public static TownshipFactory getInstance()
	{
		if(townshipFactory == null)
			townshipFactory = new TownshipFactory();
		return townshipFactory;
	}
	
	public IBuilderServices getTownshipServices()
	{
		return (IBuilderServices) townshipServices;
	}
}
