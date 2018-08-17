package com.incidentReporting.constants;

public interface Constants {

	// -----------------Database Table and Schema Names------------------//
	public static String table1Name = "incident";
	public static String table2Name = "session";
	public static String databaseName = "incidents";
	// -----------------Database Table and Schema Names------------------//

	
	// -----------------Database Config------------------//
	public static String driverName = "org.sqlite.JDBC";
	public static String databaseConnAddr = "jdbc:sqlite:incidentReport"; 
	// -----------------Database Config------------------//

	
	// -----------------Create Tables and Schema Query------------------//
	public static String createIncidentsTableQuery = "CREATE TABLE IF NOT EXISTS 'incident' ( 'incidentId' INTEGER PRIMARY KEY, 'incidentName' TEXT NOT NULL, 'incidentDesc' TEXT NOT NULL, 'emailId' TEXT NOT NULL, 'time' TEXT NOT NULL);";
	public static String createSessionTableQuery = "CREATE TABLE IF NOT EXISTS 'session' ('sessionId' INTEGER PRIMARY KEY, 'incidentId' INTEGER NOT NULL, 'sessionName' TEXT NOT NULL, 'time' TEXT NOT NULL, 'sessionStatus' TEXT NOT NULL, 'malwareScanStatus' TEXT NOT NULL);";
	// -----------------Create Tables and Schema Query------------------//


	// -----------------Select All Records From Tables------------------//	
	public static String viewAllIncidents = "Select incidentId, incidentName, incidentDesc, time , emailId from incident";
	public static String viewAllSessions = "Select * from session";
	// -----------------Create Tables and Schema Query------------------//

	
	// -----------------Check for tables------------------//
	public static String checkIncidentTableExistQuery = "SELECT * FROM incidents WHERE  table_name ='incident'";
	public static String checkSessionTableExistQuery = "SELECT * FROM session WHERE table_name ='session'";
	// -----------------Check for tables------------------//

	
	// -----------------Get Last Updated Record ------------------//
	public static String getLastIncidentRecordId = "SELECT incidentId FROM incident WHERE incidentId = (SELECT MAX(incidentId)  FROM incident);";
	public static String getLastSessionRecordId = "SELECT * FROM session WHERE sessionId = (SELECT MAX(sessionId)  FROM session);";
	// -----------------Get Last Updated Record ------------------//

	
	// -----------------Add incident and session entries to database------------------//
	public static String addNewIncident = "INSERT INTO incident(incidentName, incidentDesc, time, emailId) VALUES (?,?,?,?)";
	public static String addNewSession = "INSERT INTO session(incidentId, sessionName, time, sessionStatus, malwareScanStatus) VALUES (?,?,?,?,?)";
	// -----------------Add incident and session entries to database------------------//

	
	// -----------------Delete incident and session entries to database------------------//
	public static String deleteRequestedIncident = "Delete from incident where incidentId = ";
	public static String deleteRequestedSession = "Delete from session where sessionId = ";
	public static String deleteRequestedIncidentInSession = "Delete from session where incidentId = ";
	// -----------------Delete incident and session entries to database------------------//
	
	
	// -----------------Update incident and session entries to database------------------//
	public static String updateRequestedStatus = "UPDATE session SET sessionStatus = ?, malwareScanStatus = ? WHERE sessionId = ?;";
	public static String updateRequestedMalwareScanStatus = "UPDATE session SET malwareScanStatus = ? WHERE sessionId = ?;";
	public static String updateRequestedSessionStatus = "UPDATE session SET sessionStatus = ? WHERE sessionId = ?;";
	// -----------------Delete incident and session entries to database------------------//
}