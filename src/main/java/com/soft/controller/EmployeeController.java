package com.soft.controller;


import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.soft.entity.Employee;
import com.soft.exception.ResourceNotFoundException;
import com.soft.service.EmployeeService;

@RestController
@RequestMapping("/api")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;
	
	
	//Create employee
	@PostMapping("/save")
	public Employee createEmployee(@RequestBody Employee employee) {
		return employeeService.createEmployeeService(employee);
	}

	//Get all employees 
	@GetMapping("/allEmployee")
	public List<Employee> getAllEmployee() {
		List<Employee> emplist = employeeService.getAllEmployeeService();
		return emplist;
	}

	//Partially update employee by id using PUT()
	@PutMapping("/update/{id}")
	public Map<String, Object> updateEmployee(@RequestBody Employee emp,@PathVariable int id){
		Map<String, Object> response =employeeService.updateEmployee(id,emp);
		if(response.containsKey("updateEmployee")) {
			return response;
		}
		throw new ResourceNotFoundException("Employee not found");
	}
	
	//Get employee by id
	@GetMapping("/employee/{id}")
	public Employee getEmployeeById(@PathVariable int id) {
		return employeeService.getEmployeeByIdService(id);	
	}
	
	//Get employee sorted by salary desc
	@GetMapping("/employees/sortedbysalary")
	public ResponseEntity<List<Employee>> getEmployeesSortedBySalaryDesc() {
		List<Employee> employees = employeeService.getEmployeesSortedBySalaryDescService();
		return ResponseEntity.ok(employees);		
	}	
	
	//get employee whose name start with "R"
	 @GetMapping("/startWithR")
	public List<Employee> getEmployeeStartingWithR(){
		List<Employee> grtEmpR=employeeService.getEmployeeStartingWithRService();
		return grtEmpR;
		}
	 
	 @GetMapping("/deleteEmp/{id}")
	 public Map<String, Object> deleteEmployee(@PathVariable int id){
		  Map<String, Object> response= employeeService.deletEmployee(id);
		  return response;
	 }
}
