package com.docAuto.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.docAuto.Constants.Constants;
import com.docAuto.aggregates.DocAutomation;
import com.docAuto.service.ResultsetToExcel;

public class DAO {
	
	public void connectToDatabase() {
		
		Connection con = null;
		try {
			Class.forName(Constants.DRIVERNAME);
			// here vr4vr is database name, root is username and password
			con = DriverManager.getConnection(Constants.DATABASENAME, Constants.DATABASEUSERNAME, Constants.DATABASEPASS);
			
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select * from sessions where userId = " + DocAutomation.userId +"");
			ResultsetToExcel.rs = rs;
			System.out.println("query executed and result set sent to excel.");
			//while (rs.next())
				//System.out.println(rs.getInt(1) + "  " + rs.getString(2) + "  " + rs.getString(3));
			
		}
		catch (SQLException  e) {
			System.out.println("SQL exception while connecting to database");
			e.printStackTrace();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
