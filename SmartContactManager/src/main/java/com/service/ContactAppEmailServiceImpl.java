package com.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class ContactAppEmailServiceImpl implements ContactAppEmailService{

    @Autowired
    private JavaMailSender javaMailSenderImpl;

    @Override
    public void sendEmail(String username,String userEmail,String name, String phone){

        SimpleMailMessage newEmail = new SimpleMailMessage();
        newEmail.setTo(userEmail);
        newEmail.setSubject("This is my contact application");
        newEmail.setText("Hello " + username + ", this is the number of name : "+name+" and the number is "+phone);

        javaMailSenderImpl.send(newEmail);

    }
}
