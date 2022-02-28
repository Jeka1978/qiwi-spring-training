package com.qiwi.mail_sender;

import com.qiwi.real_spring.MainConf;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * @author Evgeny Borisov
 */
@Configuration
@ComponentScan
@EnableScheduling
public class MailConf {
    public static void main(String[] args) {
        new AnnotationConfigApplicationContext(MailConf.class);
    }
}
