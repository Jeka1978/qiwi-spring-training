package com.qiwi.mail_sender;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Random;

/**
 * @author Evgeny Borisov
 */
@Component
public class MailProducer {
    @Autowired
    private MailDistributor mailDistributor;

    @Scheduled(fixedDelay = 1000)
    public void produceMailRequest() {
        Random random = new Random();
        int type = random.nextInt(3) + 1;
        mailDistributor.distributeMail(new Message(type, null));
    }
}




