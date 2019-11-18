package com.sears.employee.registration.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class EmployeeRegistrationDaoConnection {

	public static Connection jdbcConnection() throws ClassNotFoundException, SQLException {

		String url = "jdbc:mysql://172.29.80.35:3372/training_schema";
		String username = "interns";
		String passsword = "Interns@2019";

		// Call the Driver
		Class.forName("com.mysql.jdbc.Driver");

		// Create connection
		Connection jdbcCon = DriverManager.getConnection(url, username, passsword);
		
		return jdbcCon;

	}
	public static Statement jdbcStatement() throws ClassNotFoundException, SQLException
	{
		Statement loadIntoMapSt = jdbcConnection().createStatement();
		return loadIntoMapSt;
	}
	
	}
