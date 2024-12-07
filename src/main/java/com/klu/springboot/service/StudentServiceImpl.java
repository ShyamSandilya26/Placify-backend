package com.klu.springboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.klu.springboot.model.Applications;
import com.klu.springboot.model.Jobs;
import com.klu.springboot.model.Student;
import com.klu.springboot.repositry.ApplicationRepository;
import com.klu.springboot.repositry.JobRepository;
import com.klu.springboot.repositry.StudentRepositry;

@Service
public class StudentServiceImpl implements StudentService {
	
	@Autowired
	private StudentRepositry studentRepositry;
	
	@Autowired
	private JobRepository jobRepository;
	
	@Autowired
	private ApplicationRepository applicationRepository;

	@Override
	public String studentRegistration(Student student) {
		studentRepositry.save(student);
		return "Student Registered";
	}

	@Override
	public Student checkStudentLogin(String username, String password) {
		return studentRepositry.findByNameAndPassword(username, password);
		
	}

	@Override
	public List<Jobs> viewAllJobs() {
		// TODO Auto-generated method stub
		return jobRepository.findAll();
	}

	@Override
	public String submitApplication(Applications applications) {
		applicationRepository.save(applications);
		return "Application Submitted";
	}

	
}
