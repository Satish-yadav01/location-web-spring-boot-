package com.satish.location.util;

import org.springframework.mail.javamail.JavaMailSender;

public interface EmailUtil {

    void sendEmail(String toAddress, String subject,String body);
}
