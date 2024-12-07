package com.klu.springboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.klu.springboot.model.Admin;
import com.klu.springboot.model.Employer;
import com.klu.springboot.model.Student;
import com.klu.springboot.repositry.AdminRepositry;
import com.klu.springboot.repositry.EmployerRepositry;

@Service
public class AdminServiceImpl implements AdminService {
	
	@Autowired
	private AdminRepositry adminRepositry;
	
	@Autowired
	private EmployerRepositry employerRepositry;

	@Override
	public Admin checkAdminLogin(String username, String password) {
		// TODO Auto-generated method stub
		return adminRepositry.findByUsernameAndPassword(username, password);
	}

	@Override
	public List<Employer> viewAllEmployers() {
		return employerRepositry.findAll();
		
	}

	@Override
	public void updateEmployerStatus(int EmployerId, String status) {
		// TODO Auto-generated method stub
		employerRepositry.updateStatus(EmployerId, status);
		
	}

	
	

}
