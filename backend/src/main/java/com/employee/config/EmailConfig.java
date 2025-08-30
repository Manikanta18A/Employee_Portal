package com.employee.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

@Component
public class EmailConfig {

	@Autowired
	JavaMailSender javaMailSender;
	@Value("${spring.mail.username}")
	private String from;
	
	public void sendTextMsg(String to,String text) {
		SimpleMailMessage smm = new SimpleMailMessage();
		smm.setTo(to);
		smm.setText(text);
		smm.setFrom(from);
		javaMailSender.send(smm);
		
	}

}
