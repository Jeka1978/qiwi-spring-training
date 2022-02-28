package com.qiwi.mail_sender;

import org.springframework.stereotype.Component;

/**
 * @author Evgeny Borisov
 */
@Component
public class WelcomeMailGenerator implements MailGenerator {
    @Override
    public String generateMailFromTemplate(Message message) {
        return "welcome " + message.getDetails();
    }

    @Override
    public int type() {
        return 1;
    }
}
