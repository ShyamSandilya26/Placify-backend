package com.klu.springboot.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Jobs {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(nullable = false)
	private String companyname;
	@Column(nullable = false)
	private String title;
	@Column(nullable = false)
	private String Description;
	@Column(nullable = false)
	private String salary;
	
	
	
	
	
}
