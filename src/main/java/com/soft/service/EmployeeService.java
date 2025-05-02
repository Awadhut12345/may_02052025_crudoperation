package com.soft.service;

import java.util.List;

import com.soft.entity.Employee;

public interface EmployeeService {
	
	public Employee createEmployeeService(Employee emp);

	//Get All Employee
	public List<Employee> getAllEmployeeService();
	
}
