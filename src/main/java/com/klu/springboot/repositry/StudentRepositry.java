package com.klu.springboot.repositry;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.klu.springboot.model.Student;

@Repository
public interface StudentRepositry extends JpaRepository<Student, Integer> {
	public Student findByNameAndPassword(String name,String password);
	
}
