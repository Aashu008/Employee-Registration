package com.sears.application;

import java.sql.SQLException;

import com.sears.employee.registration.operation.EmployeeRegistrationMapLoad;

public class MainApplication {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {

		System.out.println("********************Welcome to Employee Registration********************");
		EmployeeRegistrationMapLoad empRegMapLoadObj = new EmployeeRegistrationMapLoad();
		empRegMapLoadObj.loadDataIntoMap();
	}
}
