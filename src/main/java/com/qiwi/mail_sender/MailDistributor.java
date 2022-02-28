package com.qiwi.mail_sender;

/**
 * @author Evgeny Borisov
 */
public class MailDistributor {

    public void distributeMail(Message message) {

        switch (message.getType()) {
            case 1:
                //20 lines of code
                System.out.println("welcome!!!  " + message.getDetails());
                break;
            case 2:
                //50 lines of code
                System.out.println("don't call us we call you " + message.getDetails());
                break;
        }

    }
}
