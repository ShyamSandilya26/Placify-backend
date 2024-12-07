package com.klu.springboot.service;

import java.util.List;

import com.klu.springboot.model.Applications;
import com.klu.springboot.model.Employer;
import com.klu.springboot.model.Jobs;

public interface EmployerService {
	public String employerRegistration(Employer employer);
	public Employer checkEmployerLogin(String username,String password);
	public String postJob(Jobs jobs);
	public List<Applications> viewAllApplications();
	public Applications displayApplicationById(int id);

}
