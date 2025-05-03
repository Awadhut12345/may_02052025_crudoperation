package com.soft.serviceImpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.soft.entity.Employee;
import com.soft.repository.EmployeeRepository;
import com.soft.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public Employee createEmployeeService(Employee employee) {
		return employeeRepository.save(employee);
	}

	@Override
	public Employee updateEmployee(int id, Employee employeeDetails) {
		Employee employee = employeeRepository.findById(id).orElseThrow(() -> 
				new RuntimeException("Employee not found"));
		return employeeRepository.save(employee);
	}

}
