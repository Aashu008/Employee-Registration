package com.sears.employee.registration.pojo;

public class Employee {
	private String empId;
	private String name;
	private int age;
	private char gender;
	private boolean isFTE;
	private double salary;

	public String getEmpId() {
		return empId;
	}

	public void setEmpId(String empId) {
		this.empId = empId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public char getGender() {
		return gender;
	}

	public void setGender(char gender) {
		this.gender = gender;
	}

	public boolean isFTE() {
		return isFTE;
	}

	public void setFTE(boolean isFTE) {
		this.isFTE = isFTE;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

}
