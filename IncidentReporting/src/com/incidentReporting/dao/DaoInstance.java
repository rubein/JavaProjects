package com.incidentReporting.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.incidentReporting.constants.Constants;

public class DaoInstance {

	/**
	 * Will only allow one instance of connection to be used every time.
	 */
	private static Connection connection = null;

	public static final Connection getConnection() {
		if (connection == null) {
			try {
				Class.forName(Constants.driverName);
				connection = DriverManager.getConnection(Constants.databaseConnAddr);
			} catch (ClassNotFoundException e) {
				System.err.println("Database class not found.");
				e.printStackTrace();
			} catch (SQLException e) {
				System.err.println("SQL Exception while establishing connection");
				e.printStackTrace();
			}
		}
		Object o = null;
		o.hashCode();
		return connection;
	}

	public static void main(String[] args) {
		/*int min2 = Arrays.stream(new int[]{12,45,56,7,789,-9876,4})
				  .min()
				  .orElse(1);
				System.out.println(min2);
		
				Arrays.stream(new int[] { 1, 2, 3 }).map(i -> {
			        System.out.println("doubling " + i);
			        return i * 2;
			    });
			  
			    System.out.println("Stream with terminal operation");
			       System.out.println(Arrays.stream(new int[] { 1, 2, 3 }).map(i -> {
			            System.out.println("doubling " + i);
			            return i * 2;
			    }).sum());*/
				
				
/*		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
		LocalDateTime now = LocalDateTime.now();  
	    System.out.println(dtf.format(now));
	    System.out.println(now);
		
	//	System.out.println(getConnection());
	    System.out.println("------------------"+dtf.parse(dtf.format(now)));
*/	    
		
		

	}
}
