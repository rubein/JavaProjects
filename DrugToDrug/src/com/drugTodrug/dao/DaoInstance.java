package com.drugTodrug.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.drugTodrug.Mail.MailShooter;

public class DaoInstance {

	private static Connection connection = null;

	static MailShooter mail = new MailShooter();
	public static final Connection getConnection() {
		if (connection == null) {
			try {
				Class.forName("org.postgresql.Driver");
				connection = DriverManager.getConnection("jdbc:postgresql://localhost:5433/postgres", "postgres",
						"admin");
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
