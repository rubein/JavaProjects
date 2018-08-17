package com.incidentReporting.Entity;

public class Incident {

	private int incidentId;
	private String incidentName;
	private String emailId;
	private String incidentCreationTime;
	private String incidentDescription;
	
	public Incident(int id, String name, String desc, String time, String emailId){
		setIncidentId(id);
		setIncidentName(name);
		setIncidentCreationTime(time);
		setEmailId(emailId);
		setIncidentDescription(desc);
	}
	
	public int getIncidentId() {
		return incidentId;
	}

	public void setIncidentId(int incidentId) {
		this.incidentId = incidentId;
	}
	
	public String getIncidentName() {
		return incidentName;
	}
	
	public void setIncidentName(String incidentName) {
		this.incidentName = incidentName;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	
	public String getIncidentCreationTime() {
		return incidentCreationTime;
	}
	
	public void setIncidentCreationTime(String incidentCreationTime) {
		this.incidentCreationTime = incidentCreationTime;
	}
	
	public String getIncidentDescription() {
		return incidentDescription;
	}
	
	public void setIncidentDescription(String incidentDescription) {
		this.incidentDescription = incidentDescription;
	}

	@Override
	public String toString() {
		return "Incident [incidentName=" + incidentName + ", emailId=" + emailId + ", incidentCreationTime="
				+ incidentCreationTime + ", incidentDescription=" + incidentDescription + "]";
	}

}
