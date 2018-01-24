package com.zycus.township.properties;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertyDetails {
	Properties props=new Properties();

	public Properties getProps() {
		return props;
	}

	private String townshipName;
	private int maxNoOfWings;
	private int maxNoOfFloors;
	private int maxNoOfFlats;
	
	private static PropertyDetails propertyDetails;
	
	public String getTownshipName() {
		return townshipName;
	}

	public int getMaxNoOfWings() {
		return maxNoOfWings;
	}

	public int getMaxNoOfFloors() {
		return maxNoOfFloors;
	}

	public int getMaxNoOfFlats() {
		return maxNoOfFlats;
	}

	public static PropertyDetails getPropertyDetails() {
		return propertyDetails;
	}

	private PropertyDetails(){
		String filePath="C:\\Users\\Rubein\\workspace\\Township\\config\\";
		String fileName="property.properties";
		File file =new File(filePath+"\\"+fileName);
		
		InputStream fisConfig=null;
			
		try {
			fisConfig=new FileInputStream(file);
						props.load(fisConfig);
		
			townshipName=props.getProperty("TownshipName");
			maxNoOfWings=Integer.parseInt(props.getProperty("MaxNoOfWings"));
			maxNoOfFloors=Integer.parseInt(props.getProperty("MaxNoOfFloors"));
			maxNoOfFlats=Integer.parseInt(props.getProperty("MaxNoOfFlats"));
	}catch (FileNotFoundException e) {

		e.printStackTrace();
	} catch (IOException e) {

		e.printStackTrace();
		
	}finally{
		try{
			if(fisConfig!=null)
				fisConfig.close();
		}catch(IOException e)
		{
			e.printStackTrace();
		}
	}
}

	public static PropertyDetails getInstance(){
		if(propertyDetails==null)
		{
			propertyDetails= new PropertyDetails();
		}
		return propertyDetails;
	}
	
	

}