package com.soft.service;

import java.util.List;

import com.soft.entity.Employee;

public interface EmployeeService {

	//Create employee 
	public Employee createEmployeeService(Employee emp);
	
	//Partially update employee by id using PUT()
	public Employee updateEmployee(int id, Employee employeeDetails);

	//Get all employees 
	public List<Employee> getAllEmployeeService();
	
	//Get employee by id
	public Employee getEmployeeByIdService(int id);
	
	public List<Employee> getEmployeesSortedBySalaryDescService();

}
