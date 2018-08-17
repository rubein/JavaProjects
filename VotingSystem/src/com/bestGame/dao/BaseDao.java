package com.bestGame.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import com.bestGame.constants.Constants;
import com.bestGame.service.Service;

/**
 * Class performs all database related activities.
 * 
 * @author Rubein
 */
public class BaseDao {

	Connection connection = DaoInstance.getConnection();
	PreparedStatement pstmt = null;

	public boolean getVoterValidated(String email) {
		boolean status = false;
		boolean enteredRs = false;
		email = email.trim();
		String queryString = Constants.checkIfIdIsPresent + email + "'";
		try {
			pstmt = connection.prepareStatement(queryString);
			ResultSet rs = pstmt.executeQuery();

			if (rs.next()) {
				String lastVotingTimeAndDate = rs.getString(1);
				status = new Service().dateComparer(lastVotingTimeAndDate);

				/**
				 * This will update the record with current time and keep only 1
				 * entry for every email id if the status is true
				 */
				if (status == true) {
					queryString = Constants.updateAccessTime + new Service().getCurrentDateAndTime() + "'"
							+ "WHERE `voterId`='" + email + "';";
					pstmt = connection.prepareStatement(queryString);
					pstmt.executeUpdate();
					pstmt.close();
				}
				enteredRs = true;
			}
			if (!enteredRs) {
				pstmt = connection.prepareStatement(Constants.addVoterToDatabaseQuery);
				pstmt.setString(1, email);
				pstmt.setString(2, new Service().getCurrentDateAndTime());
				pstmt.executeUpdate();
				// System.out.println("Added a new voter to database.");
				status = true;
				pstmt.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return status;
	}

	/**
	 * verify if the host or ip is present in database for the incoming request.
	 * 
	 * @param hostId
	 *            senders host addr
	 * @param hostIp
	 *            senders host ip.
	 * @return is it present??
	 * @throws SQLException
	 */
	public boolean checkDatabaseForSameHost(String hostId, String hostIp) throws SQLException {
		boolean presentAndValid = false;
		boolean enteredRS = false;
		String queryString = Constants.checkForHostAndIPQuery + hostId + "'";

		pstmt = connection.prepareStatement(queryString);
		ResultSet rs = pstmt.executeQuery();

		if (rs.next()) {
			String lastVotingTimeAndDate = rs.getString(1);
			presentAndValid = new Service().dateComparer(lastVotingTimeAndDate);

			if (presentAndValid == false) {
				queryString = Constants.updateHostAccessTime + new Service().getCurrentDateAndTime() + "'"
						+ "WHERE host='" + hostId + "';";
				pstmt = connection.prepareStatement(queryString);
				pstmt.executeUpdate();
				pstmt.close();
			}
			enteredRS = true;
		}

		/**
		 * if user is not found make a new entry.
		 */
		if (!enteredRS) {

			pstmt = connection.prepareStatement(Constants.addHostToDatabaseQuery);
			pstmt.setString(1, hostIp); 
			pstmt.setString(2, new Service().getCurrentDateAndTime());
			pstmt.setString(3, hostId);
			pstmt.executeUpdate();
			System.out.println("You have added new host to database.");
			presentAndValid = true;
			pstmt.close();
		}

		return presentAndValid;
	}

	private boolean checkTableEntry(String name) {

		boolean tableExist = false;
		String query = null;
		if (name.equalsIgnoreCase(Constants.table1Name))
			query = Constants.checkVoterTableExistQuery;
		else
			query = Constants.checkSystemConfigTableExistQuery;
		try {
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery(query);
			while (rs.next()) {
				String tableName = rs.getString(3);
				if (tableName.equalsIgnoreCase(name)) {
					tableExist = true;
				}
			}
		} catch (SQLException e) {
			System.err.println("SQL Exception while checking if tables exist.");
			e.printStackTrace();
		}
		return tableExist;
	}

	public boolean createVoterTable(String tableName) {
		boolean result = false;
		try {
			Statement statement = connection.createStatement();
			if (!checkTableEntry(tableName)) {
				if (tableName.equalsIgnoreCase(Constants.table1Name)) {
					statement.executeUpdate(Constants.createVoterTableQuery);
					System.out.println("Voter table created");
					result = true;
				} else {
					statement.executeUpdate(Constants.createSysConfigTableQuery);
					System.out.println("Host table created");
					result = true;
				}
			}
		} catch (SQLException e) {
			System.err.println("Error while creating table." + tableName);
			e.printStackTrace();
		}
		return result;
	}

	/**
	 * Creates a schema in the database. 
	 * @param databasename name of the schema.
	 */
	
	public void createVoterDatabase(String databasename) {
		String queryString = Constants.createDatabase + databasename + ";";
		try {
			pstmt = connection.prepareStatement(queryString);
			boolean rs = pstmt.execute();
			if (rs) {
				System.out.println("Database Exists " + databasename);
			} else {
				System.out.println("Database Created. ");
			}
		} catch (SQLException e) {
			System.err.println("SQL Exception while creating database.");
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args) throws ParseException {
		java.util.Date dt = new java.util.Date();
		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		
	}
}
