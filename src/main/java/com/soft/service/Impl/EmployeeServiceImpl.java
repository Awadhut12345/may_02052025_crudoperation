package com.soft.service.Impl;

import java.util.Optional;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.soft.entity.Employee;
//import com.soft.exception.ResourceNotFoundException;
import com.soft.repository.EmployeeRepository;
import com.soft.service.EmployeeService;
import com.soft.util.EmployeeUtil;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Autowired
	private EmployeeUtil emputil;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private OtherService otherService;

	@Override
	public Employee createEmployeeService(Employee employee) {
		String generatePassword = emputil.genPwd();
		String generateOtp = emputil.genOtp();
		
		employee.setPassword(passwordEncoder.encode(generatePassword));
		employee.setOtp(generateOtp);
		otherService.sendEmployeeCredentials(employee,generatePassword,generateOtp);
		return employeeRepository.save(employee);
	}

	@Override
	public List<Employee> getAllEmployeeService() {
		List<Employee> emplist = employeeRepository.findAll();
		if (emplist.isEmpty()) {
	        //throw new ResourceNotFoundException("No employees found in the database");
	    }
	    return emplist;
	}

	@Override
	public Map<String,Object> updateEmployee(int id, Employee employeeDetails) {
		Map<String,Object> response = new HashMap<String, Object>();
		Optional<Employee> empid = employeeRepository.findById(id);
		if(empid.isPresent()) {
			Employee existingEmployee = empid.get();
			existingEmployee.setName(employeeDetails.getName());
			existingEmployee.setEmail(employeeDetails.getEmail());
			existingEmployee.setAddress(employeeDetails.getAddress());
			existingEmployee.setPhone(employeeDetails.getPhone());
			existingEmployee.setSalary(employeeDetails.getSalary());
		
			Employee updateemp =employeeRepository.save(existingEmployee);
			response.put("statusCode", "200");
			response.put("message", "Update successfully");
			response.put("updateEmployee", updateemp);
		}else {
			response.put("statuscode", 404);
			response.put("message","Employee not found");
		}
		return response;
	}

	 
	@Override
	public Employee getEmployeeByIdService(int id) {
		return employeeRepository.findById(id).orElseThrow(() -> new RuntimeException("Employee not found...!" + id));
		
	}

	
	@Override
	public List<Employee> getEmployeesSortedBySalaryDescService() {
		return employeeRepository.findAllByOrderBySalaryDesc();
	}

	@Override
	public List<Employee> getEmployeeStartingWithRService() {
		List<Employee> saveRemp=employeeRepository.findEmployeeStartingWithR();
		return saveRemp;
	}

	@Override
	public Map<String, Object> deletEmployee(int id) {
		Map<String, Object> response = new HashMap<String, Object>();
		Optional<Employee> empid = employeeRepository.findById(id);
		if(empid.isPresent()) {
			Employee emp=empid.get();
			employeeRepository.deleteById(id);
			response.put("StatusCode", "200");
			response.put("Message","Delete Successfully");
			response.put("DeleteEmployee", emp);
		}else {
			response.put("StatusCode", "404");
			response.put("Message", "Id Not Found");
		}
		return response;
	}

	
}
