package com.myrnaMethod.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.myrnaMethod.Mail.MailShooter;

public class DaoInstance {

	private static Connection connection = null;

	static MailShooter mail = new MailShooter();
	public static final Connection getConnection() {
		if (connection == null) {
			try {
				try {
					Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
				} catch (InstantiationException | IllegalAccessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}  
				connection=DriverManager.getConnection(  
				"jdbc:mysql://localhost:3306/sys","root","Pass@123");  
				
			} catch (ClassNotFoundException e) {
				System.err.println("Data base class not found.");
	            mail.sendMail(e.getMessage(), e);
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return connection;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new DaoInstance().getConnection();
	}
}
