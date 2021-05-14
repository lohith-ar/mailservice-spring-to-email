package com.example.mailsender;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

@Service
public class EmailSenderServ {

    @Autowired
    private JavaMailSender mailSender;

    public void sendSimpleEmail(String toEmail,
                                String body,
                                String subject) throws MessagingException {
//        SimpleMailMessage message = new SimpleMailMessage();
//
//        message.setFrom("pandemicopt.dev.team@gmail.com");
//        message.setTo(toEmail);
//        message.setText(body);
//        message.setSubject(subject);
        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message);

        helper.setTo(toEmail);
        helper.setSubject(subject);
        helper.setText("<html> <h1>Email Html</h1>\n" +
                "    <p>Email with html attachment</p></html>\n", true);

        mailSender.send(message);
        System.out.println("Mail Sent...");
    }

}
