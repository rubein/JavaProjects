package com.zycus.empAttendance.entities;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Employee {

	private int  gateNo;
	private int empId;
	private Date timestamp;
	private String operation;
	
	public Employee(int gateNo, int empId, String stamp, String operation) throws ParseException {
		super();
		SimpleDateFormat format= new SimpleDateFormat("dd/MM/yyyy-hh:mm:ss");
		Date tStamp=format.parse(stamp);
		this.gateNo = gateNo;
		this.empId = empId;
		this.timestamp = tStamp;
		this.operation = operation;
	}

	public int getGateNo() {
		return gateNo;
	}

	public int getEmpId() {
		return empId;
	}

	public Date getTimestamp() {
		return timestamp;
	}

	public String getOperation() {
		return operation;
	}

	public String toString() {
		return "Employee [gateNo=" + gateNo + ", empId=" + empId
				+ ", timestamp=" + timestamp + ", operation=" + operation + "]";
	}
}
