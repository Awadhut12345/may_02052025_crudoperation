package com.soft.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.soft.entity.Admin;
import com.soft.service.AdminService;

@Controller
@RequestMapping("/admin")
public class AdminController {
	
	@Autowired
	private AdminService adminSevice;

	@GetMapping("/register")
	public String showRegistrationForm() {
		return "admin-register";	
	}
	
	  
	@PostMapping("/save")
	public Admin createAdmin(@RequestBody Admin admin) {
		return adminSevice.createAdminService(admin);
		
	}
	
}
