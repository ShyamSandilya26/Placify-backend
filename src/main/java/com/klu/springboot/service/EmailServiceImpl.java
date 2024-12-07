package com.klu.springboot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailServiceImpl implements EmailService {
	
	@Autowired
	private JavaMailSender javaMailSender;
	
	@Value("$(spring.mail.username)")
	private String fromEmailId;

	@Override
	public void sendEmail(String recepient, String body, String subject) {
		// TODO Auto-generated method stub
		SimpleMailMessage mailMessage = new SimpleMailMessage();
		mailMessage.setFrom(fromEmailId);
		mailMessage.setTo(recepient);
		mailMessage.setText(body);
		mailMessage.setSubject(subject);
		
		javaMailSender.send(mailMessage);
		
		
	}

}
