package com.klu.springboot.service;

import java.util.List;

import com.klu.springboot.model.Admin;
import com.klu.springboot.model.Employer;


public interface AdminService {
	public Admin checkAdminLogin(String username,String password);
	public List<Employer> viewAllEmployers();
	public void updateEmployerStatus(int EmployerId, String status);
	
	
}
