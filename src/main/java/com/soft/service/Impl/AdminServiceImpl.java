package com.soft.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.soft.entity.Admin;
import com.soft.repository.AdminRepository;
import com.soft.service.AdminService;

@Service
public class AdminServiceImpl implements AdminService{
	
	@Autowired
	private AdminRepository adminRepository;

	@Override
	public Admin createAdminService(Admin admin) {
		return adminRepository.save(admin);
	}

}
