package com.klu.springboot.repositry;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.klu.springboot.model.Employer;

import jakarta.transaction.Transactional;

import java.util.List;


@Repository
public interface EmployerRepositry extends JpaRepository<Employer, Integer>  {
	public Employer  findByNameAndPassword(String name,String password);
	
	@Modifying
	@Transactional
	@Query("UPDATE Employer e SET e.status = :status WHERE e.EmployerId = :EmployerId")
	void updateStatus(@Param("EmployerId") int EmployerId, @Param("status") String status);

}
