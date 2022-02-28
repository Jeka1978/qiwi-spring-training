package com.qiwi.mail_sender;

/**
 * @author Evgeny Borisov
 */
public interface MailGenerator {
    String generateMailFromTemplate(Message message);
    int type();
}
