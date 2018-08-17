package com.incidentReporting.Entity;

public class Session {


	private int sessionId;
	private int incidentId;
	private String sessionName;
	private String malwareScanStatus;
	private String sessionCreationTime;
	private String status;
	
	public enum sessionStatus {
		inProgress, completed 
	}
	
	public Session(int sessionId, int incidentId, String sessionName, String sessionTime, String status,
			String malwareScanStatus) {
		this.sessionId = sessionId;
		this.incidentId = incidentId;
		this.sessionName = sessionName;
		this.malwareScanStatus = malwareScanStatus;
		sessionCreationTime = sessionTime;
		if(status.equalsIgnoreCase(sessionStatus.inProgress.toString()))
			this.status = sessionStatus.inProgress.toString();
		else
			this.status = sessionStatus.completed.toString();
	}

	
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getSessionId() {
		return sessionId;
	}

	public void setSessionId(int sessionId) {
		this.sessionId = sessionId;
	}
	public int getIncidentId() {
		return incidentId;
	}

	public void setIncidentId(int incidentId) {
		this.incidentId = incidentId;
	}
	
	public String getSessionName() {
		return sessionName;
	}
	
	public void setSessionName(String sessionName) {
		this.sessionName = sessionName;
	}
	
	public String getMalwareScanStatus() {
		return malwareScanStatus;
	}
	
	public void setMalwareScanStatus(String malwareScanStatus) {
		this.malwareScanStatus = malwareScanStatus;
	}
	
	public String getSessionCreationTime() {
		return sessionCreationTime;
	}
	
	public void setSessionCreationTime(String sessionCreationTime) {
		this.sessionCreationTime = sessionCreationTime;
	}


	@Override
	public String toString() {
		return "Session [sessionId=" + sessionId + ", incidentId=" + incidentId + ", sessionName=" + sessionName
				+ ", malwareScanStatus=" + malwareScanStatus + ", sessionCreationTime=" + sessionCreationTime
				+ ", status=" + status + "]";
	}
	
}
