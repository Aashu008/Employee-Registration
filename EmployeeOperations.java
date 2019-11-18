package com.sears.employee.registration.operation;

import java.util.Scanner;

import com.sears.employee.registration.arch.EmployeeRegistrationInterface;
import com.sears.employee.registration.implementation.EmployeeRegistrationImpl;

public class EmployeeOperations {

	static EmployeeRegistrationInterface empRegisterObj = new EmployeeRegistrationImpl();

	public void operations() {
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);

		System.out.println("Please select the below me ntioned options: \n" + " 1 to Add the Employee \n"
				+ " 2 to Display the List of Employees\n" + " 3 to Edit the Employee \n" + " 4 to delete Employee  \n"
				+ " 5 to Search Details of an Employee" + " 6 to Exit from the application \n");
		int selectionOfOperation = sc.nextInt();
		switch (selectionOfOperation) {
		case 1:
			empRegisterObj.addEmployee();
			break;
		case 2:
			empRegisterObj.displayEmployee();
			break;
		case 3:
			empRegisterObj.editEmployee();
			break;
		case 4:
			empRegisterObj.deleteEmployee();
			break;
		case 5:
			empRegisterObj.searchEmployee();
			break;
		case 6:
			empRegisterObj.exitApplication();
			break;
		default:
			System.out.println("Please enter from the above mentioned.");
			operations();
			break;
		}

	}

}
