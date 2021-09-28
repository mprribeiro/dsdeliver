package com.mprribeiro.dsdeliver.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {
	
	@Value("${spring.mail.username}")
	private String username;
	
	@Autowired
	private JavaMailSender emailSender;

	/*
	public void sendEmail(Order order) {
		String emailBody = BodyEmailUtil.getOrderConfirmationBody(order.getClient().getName(), order.getId().toString());
		
		try {
			MimeMessage message = emailSender.createMimeMessage();
			message.setSubject("Order Confirmation #" + order.getId().toString());
			MimeMessageHelper helper;
			helper = new MimeMessageHelper(message, true);
			helper.setFrom(username);
			helper.setTo(order.getClient().getMail());
			helper.setText(emailBody, true);
			emailSender.send(message);
		} catch (MailException | MessagingException e) {
			throw new RuntimeException(e);
		}
	} */
}
