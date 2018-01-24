package com.zycus.library.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TestDate {
public static void main(String[] args) {
	
	Date dt=new Date();
	dt.setHours(0);
	dt.setMinutes(0);
	dt.setSeconds(0);
	SimpleDateFormat format=new SimpleDateFormat("dd-MM-yyyy");
	System.out.println(format.format(dt));
	
	//convert string date to long
	String strDt="04-07-2014";
	try {
		Date dt1=format.parse(strDt);
		System.out.println(dt1);
		System.out.println(dt1.compareTo(dt));
	} catch (ParseException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	System.out.println(dt);
}
}
