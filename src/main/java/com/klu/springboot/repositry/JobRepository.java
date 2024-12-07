package com.klu.springboot.repositry;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.klu.springboot.model.Jobs;
@Repository
public interface JobRepository extends JpaRepository<Jobs, Integer> {

	
}
