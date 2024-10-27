package com.ming.brocent.service.impl;

import com.ming.brocent.domain.Email;
import com.ming.brocent.service.IEmailService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.mail.internet.MimeMessage;

@Service
@Slf4j
public class EmailServiceImpl implements IEmailService {

    private String from = "1330722500@qq.com";

    @Resource
    private JavaMailSender javaMailSender;


    public void sendEmail(Email email) {
        try {
            MimeMessage mimeMessage = javaMailSender.createMimeMessage();
            MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);
            //发送人
            mimeMessageHelper.setFrom(from);
            mimeMessageHelper.setTo(email.getSendTo());
            mimeMessageHelper.setSubject(email.getSubject());
            mimeMessageHelper.setText(email.getContent(), true);
            javaMailSender.send(mimeMessage);
        } catch (Exception e) {
            log.error("send mail error,the email subject is ->{}", email.getSubject(), e);
        }
    }
}
