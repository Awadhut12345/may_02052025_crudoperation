package com.soft.service.Impl;

import java.util.Optional;
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

	public List<Employee> getAllEmployeeService() {
		List<Employee> emplist = employeeRepository.findAll();
		return emplist;
	}

	@Override
	public Employee updateEmployee(int id, Employee employeeDetails) {
		Employee existingEmployee = employeeRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Employee not found"));
		
		existingEmployee.setName(employeeDetails.getName());
		existingEmployee.setDepartment(employeeDetails.getDepartment());
		existingEmployee.setEmail(employeeDetails.getEmail());
		existingEmployee.setAddress(employeeDetails.getAddress());
		existingEmployee.setPhone(employeeDetails.getPhone());
		existingEmployee.setSalary(employeeDetails.getSalary());
		
		return employeeRepository.save(existingEmployee);
	}

	@Override
	public Employee getEmployeeByIdService(int id) {
		return employeeRepository.findById(id).orElseThrow(() -> new RuntimeException("Employee not found...!" + id));
	}

}
