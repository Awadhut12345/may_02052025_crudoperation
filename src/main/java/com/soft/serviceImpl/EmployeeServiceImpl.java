package com.soft.serviceImpl;

import java.util.List;

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
	public List<Employee> getAllEmployeeService() {
		List<Employee> emplist = employeeRepository.findAll();
		return emplist;
	}

	

}
