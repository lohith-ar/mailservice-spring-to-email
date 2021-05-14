package com.example.mailsender;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

import javax.mail.MessagingException;

@SpringBootApplication
public class MailsenderApplication {

	@Autowired
	private EmailSenderServ service;

	public static void main(String[] args) {
		SpringApplication.run(MailsenderApplication.class, args);
	}



	@EventListener(ApplicationReadyEvent.class)
	public void triggerMail() throws MessagingException {

		service.sendSimpleEmail("vuyyuruarvr@gmail.com",
				"This is simple Email",
				"simplemail");

	}

}
