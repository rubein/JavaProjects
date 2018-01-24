package com.drugTodrug.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.postgresql.util.PSQLException;

import com.drugTodrug.Mail.MailShooter;
import com.drugTodrug.classes.ExtractExcelInformation;
import com.drugTodrug.constants.Constants;
import com.drugTodrug.pojo.Output;
import com.drugTodrug.service.Service;

/**
 * 
 * @author Rubein
 *
 */
public class BaseDao {
	
	public static List<List<String>> result = new ArrayList<List<String>>();
	int i = 0;
	public static int row;
	String sqlQuery = Constants.insertDataQuery;
	Connection connection = DaoInstance.getConnection();
	PreparedStatement pstmt = null;
	MailShooter mail = new MailShooter();
	public String getCustomerAuthenticated(String cust_email) {
		String password = "";
		System.out.println(cust_email);
		// Connection connection = DaoInstance.getConnection();
		System.out.println("Connection received.");
		PreparedStatement ps;
		String queryString = Constants.adminPasswordQuery + cust_email + "'";
		try {
			ps = connection.prepareStatement(queryString);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				password = rs.getString("Password");
			}
		} catch (SQLException e) {
            mail.sendMail(e.getMessage(), e);

			e.printStackTrace();
		}
		return password;
	}

	public boolean checkTableEntry() {
		// Connection connection = DaoInstance.getConnection();

		boolean tableExist = false;
		try {
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery(Constants.checkTableExistQuery);
			while (rs.next()) {
				tableExist = rs.getBoolean("exists");
			}
		} catch (SQLException e) {
			e.printStackTrace();
            mail.sendMail(e.getMessage(), e);

		}
		return tableExist;
	}

	public boolean createDrugTable() {
		try {
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery(Constants.createDrugTableQuery);
		} catch (PSQLException e) {
			
            mail.sendMail(e.getMessage(), e);
			System.err.println("Table already exist");
		} catch (SQLException e) {
            mail.sendMail(e.getMessage(), e);
			System.err.println(e.getMessage());
		}

		return checkTableEntry();
	}

	public void addDataToDatabase(String drug, String enzyme, String relationship, String dataResource, int row ) {
		// Connection connection = DaoInstance.getConnection();
		try {
			if (i == 0)
				pstmt = connection.prepareStatement(sqlQuery);
			connection.setAutoCommit(false);
			if (i < Constants.batchSize) {
				pstmt.setString(1, drug);
				pstmt.setString(2, enzyme);
				pstmt.setString(3, relationship);
				pstmt.setString(4, dataResource);
				pstmt.addBatch();
				i = i + 1;
				
				if (i == Constants.batchSize - 1 || row == ExtractExcelInformation.totalRows) {
					int[] result = pstmt.executeBatch();
					i = 0;
					System.out.println("The number of rows inserted: " + result.length);
					connection.commit();
				}
			}
			
		} catch (Exception e) {
			e.printStackTrace();
            mail.sendMail(e.getMessage() + "Roll back batch transaction /n", e);

			try {
				connection.rollback();
			} catch (SQLException e1) {
	            mail.sendMail(e.getMessage(), e);
				e1.printStackTrace();
			}
		} finally {
			if (pstmt != null)
				try {
					row = 0;
					if (i == 0)
						pstmt.close();
				} catch (SQLException e) {
		            mail.sendMail(e.getMessage(), e);
					e.printStackTrace();
				}
		}
	}

	public Output evaluateResult(String drug1, String drug2) {
		Output output = new Output();
		Service service = new Service();
		
		try {
			String query = Constants.evaluateQuery1 + drug1.toLowerCase().trim() + Constants.evaluateQueryPart2 + drug2.toLowerCase().trim()
					+ Constants.evaluateQueryPart3 + drug1.toLowerCase().trim() + Constants.evaluateQueryPart2 + drug2.toLowerCase().trim()
					+ Constants.evaluateQueryPart4;

			System.out.println(query);

			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery(query);
			ResultSetMetaData rsmd = rs.getMetaData();
			int columnsNumber = rsmd.getColumnCount();
			while (rs.next()) {
				int count = 0;
				String drugA = null, relationshipA = null, drugB = null, relationshipB = null, enzyme = null;
				List<String> rowData = new ArrayList<String>();
				for (int i = 1; i <= columnsNumber; i++) {
					System.out.print(rs.getString(i) + " "); 
					
					if (count == 0)
						drugA = rs.getString(i);
					if (count == 1)
						relationshipA = rs.getString(i);
					if (count == 2)
						drugB = rs.getString(i);
					if (count == 3)
						relationshipB = rs.getString(i);
					if (count == 4)
						enzyme = rs.getString(i);
					
					rowData.add(rs.getString(i));
					
					
					output.setContent(rs.getString(i));
					count = count + 1;
					
				}

				int drugADDI = new BaseDao().calculateDDI(drugA.toLowerCase().trim(), relationshipA, enzyme);
				output.setDdiValues(drugADDI);
				int drugBDDI = new BaseDao().calculateDDI(drugB.toLowerCase().trim(), relationshipB, enzyme);
				output.setDdiValues(drugBDDI);
				
				rowData.add(""+service.calculateDDI(drugADDI, drugBDDI));
					
				result.add(rowData);
				output.setDdiValues(service.calculateDDI(drugADDI, drugBDDI));
			 }
			if(Output.getContent().size() == 0)
				System.out.println("No response");
		} catch (SQLException e) {
            mail.sendMail(e.getMessage(), e);
			e.printStackTrace();
		} 

		return output;
	}

	private int calculateDDI(String drugA, String relationshipA, String enzyme) {
		int count = 0;
		try {

			String query = Constants.calculateDDIPart1 + drugA + Constants.calculateDDIPart2 + enzyme
					+ Constants.calculateDDIPart3 + relationshipA + Constants.calculateDDIPart4;
			System.out.println(" DDI Query ==> "+query);
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery(query);
			while (rs.next())
				count = rs.getInt(1);
		} catch (Exception e) {
            mail.sendMail(e.getMessage(), e);
			e.printStackTrace();
		}
		return count;
	}

	public List<String> getAutoCompleteText(String term) {
		List<String> list = new ArrayList< String>();
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
		}
		return list;
	}

	public static void main(String[] args) {
		// new BaseDao().checkTableEntry();
	//	new BaseDao().evaluateResult("Rubein", "Aunindo");
		new BaseDao().getAutoCompleteText("L");

	}

}
