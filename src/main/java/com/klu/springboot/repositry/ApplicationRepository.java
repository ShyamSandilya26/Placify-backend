package com.klu.springboot.repositry;

import org.springframework.data.jpa.repository.JpaRepository;

import com.klu.springboot.model.Applications;

public interface ApplicationRepository extends JpaRepository<Applications, Integer> {

}
