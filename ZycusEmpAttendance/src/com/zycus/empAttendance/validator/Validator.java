package com.zycus.empAttendance.validator;

import java.util.ArrayList;
import java.util.Date;

import com.zycus.empAttendance.entities.Employee;

public class Validator {
	private ArrayList<Employee> correctedList;
	private ArrayList<Employee> wrongList;
	
	public ArrayList<Employee> validateAttendaceListGetCorrected(ArrayList<Employee> attendanceList)
	{
		correctedList=new ArrayList<Employee>();
		
		for(Employee employees: attendanceList)
		{
			int gateNo=employees.getGateNo();
			int empId=employees.getEmpId();
			Date timeStamp=employees.getTimestamp();
			String operation=employees.getOperation();
			
			if((gateNo<=0 || gateNo>4) || (empId<=0) ||
			(!(operation.equalsIgnoreCase("EN")||(operation.equalsIgnoreCase("EX"))))) 
			{
				
			}
			else
			{
				correctedList.add(employees);
			}
			
		}
		return correctedList;
	}

	public ArrayList<Employee> validateAttendaceListGetWrong(ArrayList<Employee> attendanceList)
	{
		correctedList=new ArrayList<Employee>();
		wrongList=new ArrayList<Employee>();
		
		for(Employee employees: attendanceList)
		{
			int gateNo=employees.getGateNo();
			int empId=employees.getEmpId();
			Date timeStamp=employees.getTimestamp();
			String operation=employees.getOperation();
			
			if((gateNo<=0 || gateNo>4) || (empId<=0) ||
			(!(operation.equalsIgnoreCase("EN")||(operation.equalsIgnoreCase("EX"))))) 
			{
				wrongList.add(employees);		
			}
		}
		return wrongList;
	}

}
