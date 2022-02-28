package com.qiwi.mail_sender;

import org.springframework.stereotype.Component;

/**
 * @author Evgeny Borisov
 */
@Component
public class EmailCallbackMailGenerator implements MailGenerator {
    @Override
    public String generateMailFromTemplate(Message message) {
        return "don't call us we call you " + message.getDetails();
    }

    @Override
    public int type() {
        return 2;
    }
}
