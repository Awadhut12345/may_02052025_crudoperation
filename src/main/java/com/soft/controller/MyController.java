package com.soft.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RequestMapping("/mycontroller")
public class MyController {
	
	@GetMapping("/admin/dashboard")
	public String adminDashboard() {
		return "admin-dashboard";
	}
	
	@GetMapping("user/profile")
	public String userProfile() {
		return "User profile";
	}
	
	@GetMapping("/public/info")
	public String publicInfo() {
		return "Public Info";
	}

}
