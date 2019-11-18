package com.sears.employee.registration.operation;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import com.sears.employee.registration.dao.EmployeeRegistrationDaoConnection;
import com.sears.employee.registration.pojo.Employee;
import com.sears.employee.registration.utility.EmployeeRegistrationUtility;

public class EmployeeRegistrationMapLoad {

    public static Map<String, Employee> employeeMap = new HashMap<>();

	public void loadDataIntoMap() throws ClassNotFoundException, SQLException {

		
		ResultSet rs = EmployeeRegistrationDaoConnection.jdbcStatement().executeQuery("select * from employee");

		while (rs.next()) {
			Employee empObj = new Employee();

			empObj.setEmpId(String.valueOf(rs.getInt(1)));
			empObj.setName(rs.getString(2));
			empObj.setAge(rs.getInt(3));
			empObj.setSalary(rs.getInt(4));
			empObj.setFTE(EmployeeRegistrationUtility.setisFTEfromDatabase(rs.getString(5)));
			empObj.setGender(rs.getString(6).charAt(0));
			employeeMap.put(empObj.getEmpId(), empObj);
		}
		rs.close();
			EmployeeOperations empOperationObj = new EmployeeOperations();
		empOperationObj.operations();
	}

}
