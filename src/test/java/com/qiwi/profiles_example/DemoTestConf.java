package com.qiwi.profiles_example;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.stereotype.Component;

/**
 * @author Evgeny Borisov
 */
@Configuration
@TestConfiguration
public class DemoTestConf {

    @Value("${JAVA_HOME}")
    private String javaHome;

    @Bean
    public QiwiDao qiwiDao(){
        return new QiwiDaoStaging();
    }


    @Bean
    public QiwiService qiwiService() {

        return new QiwiService(qiwiDao());
    }


}
