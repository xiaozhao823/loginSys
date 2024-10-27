package com.ming.brocent.utils;

import com.ming.brocent.domain.Email;
import com.ming.brocent.service.IEmailService;
import org.springframework.stereotype.Component;
import org.thymeleaf.context.Context;
import org.thymeleaf.spring5.SpringTemplateEngine;

import javax.annotation.Resource;

@Component
public class SendEmailCodeUtil {
    @Resource
    private SpringTemplateEngine springTemplateEngine;
    @Resource
    private IEmailService emailService;

    /**
     * 发送邮件功能
     */
    public void sendEmail(String mail, String code) {
        Context context = new Context();
        context.setVariable("verificationCode", code);
        String content = springTemplateEngine.process("email_template", context);
        Email email = new Email();
        email.setSendTo(mail);
        email.setContent(content);
        email.setSubject("验证码");
        emailService.sendEmail(email);
    }
}
