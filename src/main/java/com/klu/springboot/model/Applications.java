package com.klu.springboot.model;

import java.sql.Blob;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Applications {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(nullable = false)
	private String name;
	@Column(nullable = false)
	private String email;
	@Column(nullable = false)
	private double tenthcgpa;
	@Column(nullable = false)
	private double twelethcgpa;
	@Column(nullable = false)
	private double gradutioncgpa;
	@Column(nullable = false)
	private Blob resume;
	
}
