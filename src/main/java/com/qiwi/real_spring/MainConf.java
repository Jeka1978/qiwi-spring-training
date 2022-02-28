package com.qiwi.real_spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.*;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

/**
 * @author Evgeny Borisov
 */
@Configuration
@ComponentScan
@EnableAspectJAutoProxy
@PropertySource("classpath:application.properties")
//@ImportResource("classpath:context.xml")
public class MainConf {


    @Bean
    public Quoter shakeSpearSuper() {
        return new ShakespearQuoter();
    }


    public static void main(String[] args) {

//        ApplicationContext context = SpringApplication.run(MainConf.class);
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MainConf.class);
        System.out.println();

//        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("context.xml");
//                context.getBean(TalkingRobot.class).talk();

    }
}
