package com.soft.service;

import java.util.List;
import java.util.Map;

import com.soft.entity.Employee;

public interface EmployeeService {

	//Create employee 
	public Employee createEmployeeService(Employee emp);
	
	//Partially update employee by id using PUT()
	public Map<String, Object> updateEmployee(int id, Employee employeeDetails);

	//Get all employees 
	public List<Employee> getAllEmployeeService();
	
	//Get employee by id
	public Employee getEmployeeByIdService(int id);
	
	public List<Employee> getEmployeesSortedBySalaryDescService();
	
	 public List<Employee> getEmployeeStartingWithRService();
	 
	 //delete employee by id
	 public Map<String, Object> deletEmployee(int id);

}
