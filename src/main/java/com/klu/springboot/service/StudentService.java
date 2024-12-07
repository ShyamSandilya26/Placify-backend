package com.klu.springboot.service;

import java.util.List;

import com.klu.springboot.model.Applications;
import com.klu.springboot.model.Jobs;
import com.klu.springboot.model.Student;

public interface StudentService {
	public String studentRegistration(Student student);
	public Student checkStudentLogin(String name,String password);
	public List<Jobs> viewAllJobs();
	public String submitApplication(Applications applications);

}
