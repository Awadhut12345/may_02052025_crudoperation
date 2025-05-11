package com.soft.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ShowPages {

	@GetMapping("/rgistration")
	public String employeeregistrationpage() {
		return "employeeregister";
	}
	
	@GetMapping("/emplogin")
	public String employeeloginpage() {
		return "employeelogin";
	}
}
