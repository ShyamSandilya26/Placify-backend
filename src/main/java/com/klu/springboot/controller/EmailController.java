package com.klu.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.klu.springboot.service.EmailService;

@RestController
@RequestMapping("/api/email")
public class EmailController {
	
	@Autowired
	private EmailService emailService;
	
	@GetMapping("/sendEmail")
	public String sendEmail() {
		emailService.sendEmail("shyam.sandilya26005@gmail.com", "New Job Oppurtunites alret! So What are you waiting for? Make your dreams come true", "Job Alret!");
		return "Sent Successfully";
	}

}
