package com.soft.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.soft.entity.Admin;
import com.soft.entity.Employee;
import com.soft.service.AdminService;
import com.soft.service.EmployeeService;

@Controller
@RequestMapping("/admin")
public class AdminController {
	
	@Autowired
	private AdminService adminSevice;
	@Autowired
	private EmployeeService empservice;

	@GetMapping("/register")
	public String showRegistrationForm() {
		return "admin-register";	
	}
	
	@GetMapping("/dashbord")
	public String showadminDashbordPage(Model model) {
		List<Employee> emplist = empservice.getAllEmployeeService();
		model.addAttribute("emplist", emplist);
		return "adminDashbord";
	}
	
	  
	@PostMapping("/save")
	public Admin createAdmin(@RequestBody Admin admin) {
		return adminSevice.createAdminService(admin);
		
	}
	
}
