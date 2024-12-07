package com.klu.springboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.klu.springboot.model.Applications;
import com.klu.springboot.model.Employer;
import com.klu.springboot.model.Jobs;
import com.klu.springboot.repositry.ApplicationRepository;
import com.klu.springboot.repositry.EmployerRepositry;
import com.klu.springboot.repositry.JobRepository;

@Service
public class EmployerServiceImpl implements EmployerService {

	@Autowired
	private EmployerRepositry employerRepositry;
	
	@Autowired
	private JobRepository jobRepository;
	
	@Autowired
	private ApplicationRepository applicationRepository;
	
	@Override
	public String employerRegistration(Employer employer) {
		employerRepositry.save(employer);
		return "Employer Registered";
	}

	@Override
	public Employer checkEmployerLogin(String name, String password) {
		return employerRepositry.findByNameAndPassword(name, password);
	}

	@Override
	public String postJob(Jobs jobs) {
		jobRepository.save(jobs);
		return "Job Added";
	}

	@Override
	public List<Applications> viewAllApplications() {
		// TODO Auto-generated method stub
		return applicationRepository.findAll();
	}

	@Override
	public Applications displayApplicationById(int id) {
		// TODO Auto-generated method stub
		return applicationRepository.findById(id).get();
	}


	
	

}
