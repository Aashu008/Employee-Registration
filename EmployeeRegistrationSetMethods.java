package com.sears.employee.registration.implementation;

import java.util.Scanner;

import com.sears.employee.registration.pojo.Employee;
import com.sears.employee.registration.utility.EmployeeRegistrationUtility;

public class EmployeeRegistrationSetMethods {

	Scanner sc = new Scanner(System.in);
	boolean isInValid;

	protected void setEmployeeId(Employee empObj) {
		System.out.println("Enter  Employee empId: ");
		String empId = sc.next();
		empObj.setEmpId(empId.trim());
	}

	protected void setEmployeeName(Employee empObj) {
		System.out.println("Enter  Employee Name: ");
		String name = sc.next();
		empObj.setName(name.trim());
	}

	protected void setEmployeeAge(Employee empObj) {
		System.out.println("Enter  age (Numbers Only): ");
		String age = null;
		isInValid = true;
		while (isInValid) // If incorrect value entered loop will iterate
		{
			age = sc.next().trim();
			isInValid = EmployeeRegistrationUtility.isInValidAge(age);
		}
		empObj.setAge(Integer.parseInt(age));
	}

	protected void setEmployeeGender(Employee empObj) {
		System.out.println("Enter  gender of Employee(male / female): ");
		String gender = null;
		isInValid = true;
		while (isInValid) // If incorrect value entered loop will iterate
		{

			gender = sc.next().trim();
			isInValid = EmployeeRegistrationUtility.isInValidGender(gender);
		}
		empObj.setGender(gender.charAt(0));
	}

	protected void setEmployeeIsFTEStatus(Employee empObj) {
		System.out.println("true(If the Emloyee is Full Time Employee) or false: ");
		String isFTE = null;
		isInValid = true;
		while (isInValid) {
			isFTE = sc.next().trim();
			isInValid = EmployeeRegistrationUtility.isInValidBoolean(isFTE);
		}
		empObj.setFTE(Boolean.parseBoolean(isFTE));
	}

	protected void setEmployeeSalary(Employee empObj) {
		System.out.println("Enter Salary: ");
		double salary = sc.nextDouble();
		empObj.setSalary(salary);
	}

	protected void editEmployeeId(Employee emp) {
		System.out.println("Enter new Employee Name: ");
		String name = sc.next();
		emp.setName(name);
	}

	protected void editEmployeeAge(Employee emp) {
		System.out.println("Enter new Employee's age (Numbers Only): ");
		String age = null;
		isInValid = true;
		while (isInValid) // If incorrect value entered loop will
							// iterate
		{
			age = sc.next().trim();
			isInValid = EmployeeRegistrationUtility.isInValidAge(age);
		}
		emp.setAge(Integer.parseInt(age));
	}

	protected void editEmployeeGender(Employee emp) {
		System.out.println("Enter new Employee's Gender(M/F): ");
		String gender = null;
		isInValid = true;
		while (isInValid) // If incorrect value entered loop will
							// iterate
		{

			gender = sc.next().trim();
			isInValid = EmployeeRegistrationUtility.isInValidGender(gender);
		}
		emp.setGender(gender.charAt(0));
	}

	protected void editEmployeeIsFTEStatus(Employee emp) {
		System.out.println("true(If the Emloyee is Full Time Employee) or false: ");
		String isFTE = null;
		isInValid = true;
		while (isInValid) {
			isFTE = sc.next().trim();
			isInValid = EmployeeRegistrationUtility.isInValidBoolean(isFTE);
		}
		emp.setFTE(Boolean.parseBoolean(isFTE));
	}

	protected void editEmployeeSalary(Employee emp) {
		System.out.println("Enter new Salary: ");
		double salary = sc.nextDouble();
		emp.setSalary(salary);
	}

}
