package com.klu.springboot.service;

public interface EmailService {

	public void sendEmail(String recepient,String body,String subject);
}
