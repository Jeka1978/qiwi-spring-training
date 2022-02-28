package com.qiwi.real_spring;

import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.List;

import static java.util.Arrays.asList;

/**
 * @author Evgeny Borisov
 */
@Component
@Order(1)
public class TerminatorQuoter implements Quoter {

    private List<String> messages;


    @Value("${terminator}")
    public void setMessages(String[] messages) {
        this.messages = asList(messages);
    }

    @Override
    public void sayQuote() {
        messages.forEach(System.out::println);
    }
}



