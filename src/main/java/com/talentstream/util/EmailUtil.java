package com.talentstream.util;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
@Service
public class EmailUtil {
	    @Autowired
	    private JavaMailSender javaMailSender;

	    public void sendOtpEmail(String email, String otp) throws MessagingException {
	        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
	        MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage);
	        mimeMessageHelper.setTo(email);
	        mimeMessageHelper.setSubject("Verify OTP");
	        mimeMessageHelper.setText(otp);

	        javaMailSender.send(mimeMessage);
	    }
}
