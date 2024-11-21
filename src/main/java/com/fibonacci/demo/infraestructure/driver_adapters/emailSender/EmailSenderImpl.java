package com.fibonacci.demo.infraestructure.driver_adapters.emailSender;

import com.fibonacci.demo.domain.model.EmailDetails;
import com.fibonacci.demo.domain.model.gateways.EmailGateway;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.Objects;

@Service
public class EmailSenderImpl implements EmailGateway {
    @Autowired
    private JavaMailSender javaMailSender;

    @Override
    public void sendEmail(EmailDetails emailDetails) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(emailDetails.getRecipient());
        message.setSubject(emailDetails.getSubject());
        message.setText(emailDetails.getMsgBody());

        javaMailSender.send(message);
    }
}
