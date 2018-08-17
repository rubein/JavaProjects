package com.bestGame.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.bestGame.constants.Constants;

public class DaoInstance {
	
	/**
	 * Will only allow one instance of connection to be used every time.
	 */
	private static Connection connection = null;

	public static final Connection getConnection() {
		if (connection == null) {
			try {
				Class.forName(Constants.driverName);  
				connection=DriverManager.getConnection(  
				Constants.databaseConnAddr,Constants.databaseUserName,Constants.databasePassword);  
			} catch (ClassNotFoundException e) {
				System.err.println("Database class not found.");
				e.printStackTrace();
			} catch (SQLException e) {
				System.err.println("SQL Exception while establishing connection");
				e.printStackTrace();
			}
		}
		return connection;
	}

	public static void main(String[] args) {
		new DaoInstance().getConnection();
	}
}
