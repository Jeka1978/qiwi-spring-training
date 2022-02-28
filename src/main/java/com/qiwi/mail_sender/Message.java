package com.qiwi.mail_sender;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author Evgeny Borisov
 */
@Data
@AllArgsConstructor
public class Message {

    private int type; // 1 - send Welcome mail, 2 - send email callback
    private String details;
}
