package com.myrnaMethod.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.postgresql.util.PSQLException;

import com.myrnaMethod.Mail.MailShooter;
import com.myrnaMethod.constants.Constants;

/**
 * @author Rubein
 */
public class BaseDao {

	public int result = 0;
	int i = 0;
	public static int row;
	String sqlQuery = Constants.insertDataQuery;
	Connection connection = DaoInstance.getConnection();
	PreparedStatement pstmt = null;
	MailShooter mail = new MailShooter();
	public int lastRow = -1;

	public String getCustomerAuthenticated(String cust_email) {
		String password = "";
		System.out.println(cust_email);
		// Connection connection = DaoInstance.getConnection();
		System.out.println("Connection received.");
		PreparedStatement ps;
		String queryString = Constants.adminPasswordQuery + cust_email + "'";
		System.err.println("admin password query is : " + queryString);
		try {
			ps = connection.prepareStatement(queryString);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				System.out.println("entered rs");
				password = rs.getString("Password");
				System.err.println(password);
			}
		} catch (SQLException e) {
			mail.sendMail(e.getMessage(), e);
			e.printStackTrace();
		}
		return password;
	}

	public boolean checkTableEntry(String name) {

		boolean tableExist = false;
		String query = null;
		if (name.equalsIgnoreCase(Constants.table1Name))
			query = Constants.checkMemberTableExistQuery;

		if (name.equalsIgnoreCase(Constants.table2Name))
			query = Constants.checkFoodTableExistQuery;

		if (name.equalsIgnoreCase(Constants.table3Name))
			query = Constants.checkFoodIntakeTableExistQuery;

		try {
			Statement statement = connection.createStatement();
			tableExist = statement.execute(query);
			System.out.println("table " + name + " is present ? " + tableExist);
		} catch (SQLException e) {
			e.printStackTrace();
			mail.sendMail(e.getMessage(), e);
		}
		return tableExist;
	}

	public boolean createFoodTable(String tableName) {
		boolean result = false;
		try {
			Statement statement = connection.createStatement();
			if (!checkTableEntry(tableName)) {
				if (tableName.equalsIgnoreCase(Constants.table1Name)) {
					statement.executeQuery(Constants.createMemberTableQuery);
					System.out.println("Member table created");
					result = true;
				}

				if (tableName.equalsIgnoreCase(Constants.table2Name)) {
					statement.executeQuery(Constants.createFoodTableQuery);
					System.out.println("Food table created");
					result = true;
				}

				if (tableName.equalsIgnoreCase(Constants.table3Name)) {
					statement.executeQuery(Constants.createFoodIntakeTableQuery);
					System.out.println("Food Intake table created");
					result = true;
				}
			}
		} catch (PSQLException e) {
			mail.sendMail(e.getMessage(), e);
			System.err.println("Table already exist");
		} catch (SQLException e) {
			mail.sendMail(e.getMessage(), e);
			System.err.println(e.getMessage());
		}
		return result;
	}

	public void addDataToDatabase(String foodName, float amount, float calories, float protein, float fats,
			float carbohydrates, float fiber, String valid, String catagory) {
		try {
			if (i == 0)
				pstmt = connection.prepareStatement(sqlQuery);

			pstmt.setInt(1, lastRow);
			pstmt.setString(2, foodName);
			pstmt.setFloat(3, amount);
			pstmt.setFloat(4, calories);
			pstmt.setFloat(5, protein);
			pstmt.setFloat(6, fats);
			pstmt.setFloat(7, carbohydrates);
			pstmt.setFloat(8, fiber);
			pstmt.setString(9, valid);
			pstmt.setString(10, catagory);
			result = pstmt.executeUpdate();

			// this variable keeps track of the last row data is entered and
			// increments the variable by 1 every time.
			lastRow = lastRow + 1;

		} catch (Exception e) {
			e.printStackTrace();
			mail.sendMail(e.getMessage() + " Exception while loading data in database /n", e);
		} finally {
			if (pstmt != null)
				try {
					pstmt.close();
				} catch (SQLException e) {
					mail.sendMail(e.getMessage(), e);
					e.printStackTrace();
				}
		}
	}

	public int getLastRowNumberForFoodDB(String table2name) {
		ResultSet rs;
		int count = -1;
		String query = Constants.lastRowQueryForFoodDB + table2name + ";";
		try {
			Statement statement = connection.createStatement();
			rs = statement.executeQuery(query);
			rs.next();
			count = rs.getInt(1);

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return count;
	}

	public List<String> getAutoCompleteText(String term) {
		List<String> list = new ArrayList<String>();
		PreparedStatement ps = null;
		String data;
		try {
			ps = connection.prepareStatement("SELECT Distinct drug FROM drugsList  WHERE drug LIKE ?");
			ps.setString(1, term + "%");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				data = rs.getString("drug");
				list.add(data);
			}
		} catch (Exception e) {
			mail.sendMail(e.getMessage(), e);
			System.out.println(e.getMessage());
		} finally {
			try {
				ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return list;
	}

	public void addNewMemberToDatabase(String firstName, String lastName, String email, String password,
			String startDate, int validFor) {
		try {
			int memberId = getLastRowNumberForFoodDB(Constants.table1Name);
			pstmt = connection.prepareStatement(Constants.insertNewMember);
			pstmt.setInt(1, (memberId + 1));
			pstmt.setString(2, firstName);
			pstmt.setString(3, lastName);
			pstmt.setInt(4, 1);
			pstmt.setString(5, startDate);
			pstmt.setInt(6, validFor);
			pstmt.setString(7, email);
			pstmt.setString(8, password);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			System.err.println("Error while adding new user member" + firstName + " " + lastName);
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
			} catch (SQLException e) {
				System.err.println("Error while closing prepared statement for adding new member");
				e.printStackTrace();
			}
		}
	}

	/*
	 * private int getLastRecordNumberId(String tableName) throws SQLException {
	 * Statement stmt = connection.createStatement(); ResultSet rs =
	 * stmt.executeQuery(Constants.getLastColumnNumber); int lastRow = -1;
	 * while(rs.next()){ lastRow = rs.getInt(1); } return lastRow; }
	 */

	public static void main(String[] args) throws SQLException {
		// new BaseDao().checkTableEntry();
		// new BaseDao().evaluateResult("Rubein", "Aunindo");
		// new BaseDao().getAutoCompleteText("L");
		// System.out.println(new
		// BaseDao().getLastRowNumberForFoodDB(Constants.table2Name));
		System.out.println(new BaseDao().getLastRowNumberForFoodDB(Constants.table2Name));

	}

/*	public void addOneFoodItem(String foodName, float amount, float unit, float calories, float protein, float fats,
			float carbs, float fiber) {
		int lastRow = -1;
		try {
			lastRow = getLastRowNumberForFoodDB(Constants.table2Name);

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}*/

}
