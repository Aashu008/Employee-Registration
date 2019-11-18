package com.sears.employee.registration.implementation;

import java.sql.SQLException;
import java.util.Scanner;

import com.sears.employee.registration.arch.EmployeeRegistrationInterface;
import com.sears.employee.registration.dao.EmployeeRegistrationDaoConnection;
import com.sears.employee.registration.operation.EmployeeOperations;
import com.sears.employee.registration.operation.EmployeeRegistrationMapLoad;
import com.sears.employee.registration.pojo.Employee;

public class EmployeeRegistrationImpl implements EmployeeRegistrationInterface {

	Scanner sc = new Scanner(System.in);
	boolean isInValid;

	EmployeeOperations empOperationObj = new EmployeeOperations();
	EmployeeRegistrationSetMethods empSetMethodsObj = new EmployeeRegistrationSetMethods();

	@Override
	public void addEmployee() {

		Employee empObj = new Employee();

		empSetMethodsObj.setEmployeeId(empObj);

		empSetMethodsObj.setEmployeeName(empObj);

		empSetMethodsObj.setEmployeeAge(empObj);

		empSetMethodsObj.setEmployeeGender(empObj);

		empSetMethodsObj.setEmployeeIsFTEStatus(empObj);

		empSetMethodsObj.setEmployeeSalary(empObj);

		EmployeeRegistrationMapLoad.employeeMap.put(empObj.getEmpId(), empObj);

		try {
			
			int n =EmployeeRegistrationDaoConnection.jdbcStatement().executeUpdate
			("INSERT INTO employee(EmployeeId,name,age,salary,isFTE,Gender)VALUES("+Integer.parseInt(empObj.getEmpId())+","+empObj.getName()+","+ empObj.getAge() +","+empObj.getSalary()+",'t',"+String.valueOf(empObj.getGender())+")");
					System.out.println(n);
		} catch (ClassNotFoundException e  ) {
			System.out.println("Class not found");
			e.getStackTrace();
		}
		catch(SQLException e)
		{
			System.out.println("Couldn't connect to Database");
			e.getStackTrace();
		}

		System.out.println("Do you want to add new details: Y or N");
		char toAddNewValue = sc.next().charAt(0);
		if (toAddNewValue == 'y' || toAddNewValue == 'Y')
			addEmployee();
		else
			empOperationObj.operations();

	}

	@Override
	public void deleteEmployee() {

		System.out.println("Please Enter the Employee Id to be deleted: ");
		String deleteEmpId = sc.next();
		if (EmployeeRegistrationMapLoad.employeeMap.containsKey(deleteEmpId)){
			EmployeeRegistrationMapLoad.employeeMap.remove(deleteEmpId);
			try {
				int m = EmployeeRegistrationDaoConnection.jdbcStatement().executeUpdate
						("DELETE FROM employee where (EmployeeId= "+deleteEmpId+")"); 
                System.out.println(m);
			} catch (ClassNotFoundException | SQLException e) {
				System.out.println("Couldn't connect to Database");
				e.getStackTrace();
			}
		}
		else {
			System.out.println("The EmpId you entered doesn't exist");
			deleteEmployee();
		}
		empOperationObj.operations();
	}

	@Override
	public void editEmployee() {

		System.out.println("Please Enter the Employee Id to be edited: ");
		String editEmpId = sc.next();
		if (EmployeeRegistrationMapLoad.employeeMap.containsKey(editEmpId)) {
			System.out.println("Employee Id: " + EmployeeRegistrationMapLoad.employeeMap.get(editEmpId).getEmpId());
			System.out.println("Employee Name: " + EmployeeRegistrationMapLoad.employeeMap.get(editEmpId).getName());
			System.out.println("Employee age:  " + EmployeeRegistrationMapLoad.employeeMap.get(editEmpId).getAge());
			System.out.println("Employee Gender: " + EmployeeRegistrationMapLoad.employeeMap.get(editEmpId).getGender());
			System.out.println("Employee is Full Time: " + EmployeeRegistrationMapLoad.employeeMap.get(editEmpId).isFTE());
			System.out.println("Employee Salary: " + EmployeeRegistrationMapLoad.employeeMap.get(editEmpId).getSalary());

			System.out.println("Do you want to edit these details or any other details : " + "1 for yes \n2 for No");
			int toEditOrNot = sc.nextInt();
			if (toEditOrNot == 1) {
				Employee emp = EmployeeRegistrationMapLoad.employeeMap.get(editEmpId);
				emp.setEmpId(editEmpId);

				empSetMethodsObj.editEmployeeId(emp);

				empSetMethodsObj.editEmployeeAge(emp);

				empSetMethodsObj.editEmployeeGender(emp);

				empSetMethodsObj.editEmployeeIsFTEStatus(emp);

				empSetMethodsObj.editEmployeeSalary(emp);

				EmployeeRegistrationMapLoad.employeeMap.replace(editEmpId, emp);
			}

			else
				editEmployee();
		}

		else {
			System.out.println("The EmpId you entered doesn't exist");
			editEmployee();
		}

		empOperationObj.operations();
	}

	@Override
	public void exitApplication()  {

		try {
			EmployeeRegistrationDaoConnection.jdbcStatement().close();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		try {
			EmployeeRegistrationDaoConnection.jdbcConnection().close();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		System.out.println("Application Closed");
		System.exit(0);

	}

	@Override
	public void displayEmployee() {

		if (!EmployeeRegistrationMapLoad.employeeMap.isEmpty()) {
			for (Employee emp : EmployeeRegistrationMapLoad.employeeMap.values()) {
				System.out.println("***********New Empoyee Details***********");
				System.out.println("Employee Id: " + emp.getEmpId());
				System.out.println("Employee Name: " + emp.getName());
				System.out.println("Employee age:  " + emp.getAge());
				System.out.println("Employee Gender: " + emp.getGender());
				System.out.println("Employee is Full Time: " + emp.isFTE());
				System.out.println("Employee Salary: " + emp.getSalary());
			}
			empOperationObj.operations();

		}
	}

	@Override
	public void searchEmployee() {

		System.out.println("Please Enter the Employee Id to be Searched: ");
		String searchEmpId = sc.next();
		if (EmployeeRegistrationMapLoad.employeeMap.containsKey(searchEmpId)) {
			System.out.println("Employee Id: " + EmployeeRegistrationMapLoad.employeeMap.get(searchEmpId).getEmpId());
			System.out.println("Employee Name: " + EmployeeRegistrationMapLoad.employeeMap.get(searchEmpId).getName());
			System.out.println("Employee age:  " + EmployeeRegistrationMapLoad.employeeMap.get(searchEmpId).getAge());
			System.out.println("Employee Gender: " + EmployeeRegistrationMapLoad.employeeMap.get(searchEmpId).getGender());
			System.out.println("Employee is Full Time: " + EmployeeRegistrationMapLoad.employeeMap.get(searchEmpId).isFTE());
			System.out.println("Employee Salary: " + EmployeeRegistrationMapLoad.employeeMap.get(searchEmpId).getSalary());

			empOperationObj.operations();
		}
		System.out.println("The EmployeId you Entered doesn't exists");
		searchEmployee();

	}
}
