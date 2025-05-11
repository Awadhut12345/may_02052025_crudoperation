package com.soft.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.soft.entity.Employee;

@Service
public class OtherService {

	@Autowired
	private JavaMailSender mailSender; 
	
	public void sendEmployeeCredentials(Employee emp , String password , String otp) {
		SimpleMailMessage message = new SimpleMailMessage();
		message.setTo(emp.getEmail());
		message.setSubject("Your Registration Details");
		
		String text = String.format("Weolome to the Company \n\n "
				+ "Here Your Registration Detail : \n"
				+ "Name : %s\n"
				+ "Email : %s\n"
				+ "Phone : %d\n"
				+ "Address : %s\n"
				+ "Salary : %.2f\n"
				+ "Roles : %s\n"
				+ "Active : %s\n"
				+ "Password : %s\n"
				+ "OTP : %s\n"
				+ "Please use these credentials to log in.", emp.getName(),emp.getEmail(),emp.getPhone(),emp.getAddress(),
															emp.getSalary(),emp.getRole().toString(),emp.isActive()?"YES":"NO",
																password , otp);
		message.setText(text);
		mailSender.send(message);
	}
}
