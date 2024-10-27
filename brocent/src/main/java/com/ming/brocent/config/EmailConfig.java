package com.ming.brocent.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import java.util.Properties;

@Configuration
public class EmailConfig {

    @Bean
    public JavaMailSenderImpl JavaMailSender(){
        JavaMailSenderImpl javaMailSender = new JavaMailSenderImpl();
        javaMailSender.setHost("smtp.qq.com");
        javaMailSender.setUsername("1330722500@qq.com");
        //密码是qq账户中获取的授权码
        javaMailSender.setPassword("vbwwhgqbbbyiifig");
        javaMailSender.setDefaultEncoding("UTF-8");
        Properties props = new Properties();
        props.put("mail.smtp.ssl.enable", "true");
        javaMailSender.setJavaMailProperties(props);
        return javaMailSender;
    }
}
