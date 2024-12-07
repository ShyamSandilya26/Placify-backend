package com.klu.springboot.repositry;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.klu.springboot.model.Admin;
import java.util.List;


@Repository
public interface AdminRepositry extends JpaRepository<Admin, String> {
	
	
	public Admin findByUsernameAndPassword(String username, String password);
	

}
