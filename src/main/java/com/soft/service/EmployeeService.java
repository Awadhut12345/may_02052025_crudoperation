package com.soft.service;

import com.soft.entity.Employee;

public interface EmployeeService {
	
	public Employee createEmployeeService(Employee emp);
	
	public Employee updateEmployee(int id, Employee employeeDetails);

}
