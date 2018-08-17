package com.incidentReporting.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import com.incidentReporting.Entity.Incident;
import com.incidentReporting.Entity.Session;
import com.incidentReporting.constants.Constants;

/**
 * Class performs all database related activities.
 * 
 * @author Rubein
 */
public class BaseDao implements AutoCloseable{

	Connection connection = DaoInstance.getConnection();
	public static int incidentId;
	public static int sessionId;

	/**
	 * Static block to create tables database and tables if not exist
	 */
	static {
		BaseDao dao = new BaseDao();
		dao.createIncidentsTable(Constants.table1Name);
		dao.createIncidentsTable(Constants.table2Name);
	}

	/**
	 * This method creates table for incident db.
	 * @param tableName name of table to be created.
	 * @return status.
	 */
	public boolean createIncidentsTable(String tableName) {
		boolean result = false;
		try {
			System.out.println("creating incidents table");
			Statement statement = connection.createStatement();

			if (tableName.equalsIgnoreCase(Constants.table1Name)) {
				statement.execute(Constants.createIncidentsTableQuery);
				result = true;
			} else {
				statement.execute(Constants.createSessionTableQuery);
				result = true;
			}
		} catch (SQLException e) {
			System.err.println("Error while creating table." + tableName);
			e.printStackTrace();
		}
		return result;
	}

	/**
	 * Adds incident to the database.
	 * @param incidentName
	 * @param incidentDesc
	 * @param time
	 * @param email
	 * @return incidentId
	 */
	public int addIncidentToDatabase(String incidentName, String incidentDesc, String time, String email) {

		String queryString = Constants.addNewIncident;

		try (PreparedStatement pstmt = connection.prepareStatement(queryString);){
			pstmt.setString(1, incidentName);
			pstmt.setString(2, incidentDesc);
			pstmt.setString(3, time);
			pstmt.setString(4, email);
			pstmt.execute();
			System.out.println("You have added new incident to database.");
			
			incidentId = getUpdatedIncidentId();

		} catch (SQLException e) {
			System.err.println("SQL Exception while creating database.");
			e.printStackTrace();
		}
		return incidentId;
	}

	/**
	 * Adds sessions to database
	 * @param incidentId
	 * @param sessionName
	 * @param time
	 * @param status
	 * @param malwareScanStatus
	 * @return
	 */
	public int addSessionToDatabase(int incidentId, String sessionName, String time, String status,
			String malwareScanStatus) {

		String queryString = Constants.addNewSession;
		try (PreparedStatement pstmt = connection.prepareStatement(queryString);) {
			pstmt.setInt(1, incidentId);
			pstmt.setString(2, sessionName);
			pstmt.setString(3, time);
			pstmt.setString(4, status);
			pstmt.setString(5, malwareScanStatus);
			pstmt.executeUpdate();
			System.out.println("You have added new session to database.");
		} catch (SQLException e) {
			System.err.println("SQL Exception while creating database.");
			e.printStackTrace();
		}
		return incidentId;
	}

	/**
	 * Gets teh incident Id
	 * @return
	 * @throws SQLException
	 */
	private int getUpdatedIncidentId() throws SQLException {
		String query = Constants.getLastIncidentRecordId;
		Statement statement = connection.createStatement();
		ResultSet rs = statement.executeQuery(query);
		int incidentId = -1;
		if (rs.next())
			incidentId = rs.getInt(1);

		return incidentId;
	}

	public static void main(String[] args) throws ParseException {

		// new BaseDao().dropAllIncidents();
		// new BaseDao().addIncidentToDatabase("Aakash", "test", "123456789",
		// "'akash@aakash.com'");
		// new BaseDao().viewAllIncidents();
		// new BaseDao().dropAllSessions();
		// new BaseDao().addSessionToDatabase(6, "test session", "6758392",
		// Session.sessionStatus.inProgress.toString(), "success");
		// new BaseDao().viewAllSessions();

		/*
		 * String buttonClicked = "Delete 100"; buttonClicked =
		 * buttonClicked.substring(7, buttonClicked.length());
		 * System.out.println(buttonClicked);
		 */

		// new BaseDao().viewAllSessions();
		// new BaseDao().updateRequestedIncident(1, "completed", "failed");
		// new BaseDao().viewAllSessions();
	}

	
	/**
	 * Runs Query to view all incidents.
	 */
	public void viewAllIncidents() {
		String query = Constants.viewAllIncidents;
		try (Statement statement = connection.createStatement();) {
			ResultSet rs = statement.executeQuery(query);
			List<Incident> incidentsList = new ArrayList<Incident>();
			int i = 1;
			while (rs.next()) {
				int id = rs.getInt(i);
				String name = rs.getString(i + 1);
				String desc = rs.getString(i + 2);
				String time = rs.getString(i + 3);
				String email = rs.getString(i + 4);
				Incident incident = new Incident(id, name, desc, time, email);
				incidentsList.add(incident);
			}
			System.out.println(incidentsList);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	
	/**
	 * Query displays all sessions.
	 */
	public void viewAllSessions() {

		String query = Constants.viewAllSessions;
		try (Statement statement = connection.createStatement();) {
			ResultSet rs = statement.executeQuery(query);
			List<Session> sessionsList = new ArrayList<Session>();
			int i = 1;

			while (rs.next()) {
				int sessionId = rs.getInt(i);
				int incidentId = rs.getInt(i + 1);
				String sessionName = rs.getString(i + 2);
				String sessionTime = rs.getString(i + 3);
				String status = rs.getString(i + 4);
				String malwareScanStatus = rs.getString(i + 5);
				Session session = new Session(sessionId, incidentId, sessionName, sessionTime, status,
						malwareScanStatus);
				sessionsList.add(session);
			}

			System.out.println(sessionsList);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * Query drops the incident table.
	 */
	public void dropAllIncidents() {
		String query = "Drop table incident";
		try (Statement statement = connection.createStatement();) {
			statement.execute(query);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Query drops session table.
	 */
	public void dropAllSessions() {
		String query = "Drop table session";
		try (Statement statement = connection.createStatement();) {
			statement.execute(query);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
/**
 * This function deletes requested incident.
 * @param buttonClicked
 */
	public void deleteRequestedIncident(String buttonClicked) {
		String query = Constants.deleteRequestedIncident;
		query = query + buttonClicked;
		try (Statement statement = connection.createStatement();) {
			statement.executeUpdate(query);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		deleteRequestedSessionForIncidents(Integer.parseInt(buttonClicked));
	}

	/**
	 * this function deletes incident from session. Cascade/Relationship effect.
	 * @param parseInt
	 */
	private void deleteRequestedSessionForIncidents(int parseInt) {
		String query = Constants.deleteRequestedIncidentInSession;
		query = query + parseInt;
		try (Statement statement = connection.createStatement();) {
			statement.executeUpdate(query);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * This query deletes requested session.
	 * @param buttonClicked
	 */
	public void deleteRequestedSession(int buttonClicked) {
		String query = Constants.deleteRequestedSession;
		query = query + buttonClicked;
		try (Statement statement = connection.createStatement();) {
			statement.executeUpdate(query);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/*
	 * This query updates requested incident.
	 */
	public void updateRequestedIncident(int sessionId2, String sessionStatus, String malwareScanStatus) {
		String updateQuery = Constants.updateRequestedStatus;
		try (PreparedStatement pstmt = connection.prepareStatement(updateQuery);) {
			pstmt.setString(1, sessionStatus);
			pstmt.setString(2, malwareScanStatus);
			pstmt.setInt(3, sessionId2);
			int a = pstmt.executeUpdate();
			System.out.println(a);
		} catch (SQLException e) {
			System.err.println("Err while updating status.");
			e.printStackTrace();
		}
	}

	/**
	 * updates malware status alone.
	 * @param parseInt
	 * @param malwareScanStatus
	 */
	public void updateRequestedSessionMalwareStatus(int parseInt, String malwareScanStatus) {
		String updateQuery = Constants.updateRequestedMalwareScanStatus;
		try (PreparedStatement pstmt = connection.prepareStatement(updateQuery);) {
			pstmt.setString(1, malwareScanStatus);
			pstmt.setInt(2, parseInt);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			System.err.println("Err while updating malware status.");
			e.printStackTrace();
		}

	}

	/**
	 * updates session status alone.
	 * @param parseInt
	 * @param sessionStatus
	 */
	public void updateRequestedSessionSessionStatus(int parseInt, String sessionStatus) {
		String updateQuery = Constants.updateRequestedSessionStatus;
		try (PreparedStatement pstmt = connection.prepareStatement(updateQuery);) {
			pstmt.setString(1, sessionStatus);
			pstmt.setInt(2, parseInt);
			pstmt.executeUpdate();

		} catch (SQLException e) {
			System.err.println("Err while updating session status.");
			e.printStackTrace();
		}
	}

	
	@Override
	public void close() throws Exception {
		System.out.println("All resources closed.");
	}

}
