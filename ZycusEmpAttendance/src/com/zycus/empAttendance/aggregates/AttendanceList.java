package com.zycus.empAttendance.aggregates;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

import com.zycus.empAttendance.entities.Employee;
import com.zycus.empAttendance.validator.Validator;

public class AttendanceList {

	private ArrayList<Employee> collection1;
	private Collection<Employee> collection;
	private ArrayList<Employee> correctedAttendanceList;
	private ArrayList<Employee> wrongAttendanceList;
	private static AttendanceList attendanceList;

	private AttendanceList() throws FileNotFoundException, InterruptedException
	{
		collection1 = new ArrayList<Employee>();
		collection=Collections.synchronizedList(collection1);
		getAllAttendanceList();
	}
	public static AttendanceList getInstance() throws FileNotFoundException, InterruptedException
	{
		if(attendanceList==null)
		{
			attendanceList=new AttendanceList();
		}
		return attendanceList;
	}
	
	public void getAllAttendanceList() throws FileNotFoundException, InterruptedException
	{
		Thread t1=new Thread(new Thread1(collection));
		Thread t2=new Thread(new Thread2(collection));
		Thread t3=new Thread(new Thread3(collection));
		Thread t4=new Thread(new Thread4(collection));

		t1.start();
		t2.start();
		t3.start();
		t4.start();

		t1.join();
		t2.join();
		t3.join();
		t4.join();
	}
	public ArrayList<Employee> getAllCorrectedAttendanceList() throws FileNotFoundException, InterruptedException
	{
		Validator validator=new Validator();
		correctedAttendanceList=validator.validateAttendaceListGetCorrected(collection1);
		return correctedAttendanceList;
	}
	
	public ArrayList<Employee> getAllWrongAttendanceList()
	{
		Validator validator=new Validator();
		wrongAttendanceList=validator.validateAttendaceListGetWrong(collection1);
		return wrongAttendanceList;
	}
	
	public void saveCorrectedAttendanceList(String fileName) throws IOException
	{
		SaveAttendanceList save=new SaveAttendanceList();
		save.saveAttendanceList(correctedAttendanceList, fileName);
	}
	
	public void saveWrongAttendanceList(String fileName) throws IOException
	{
		SaveAttendanceList save=new SaveAttendanceList();
		save.saveAttendanceList(wrongAttendanceList, fileName);
	}

}
