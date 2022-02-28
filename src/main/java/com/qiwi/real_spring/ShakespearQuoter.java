package com.qiwi.real_spring;

import com.qiwi.my_spring.InjectRandomInt;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Lazy;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @author Evgeny Borisov
 */


@Order(2)
@Book
@Film
public class ShakespearQuoter implements Quoter {
    @Setter
    @Value("${shake}")
    private String message;

    @InjectRandomInt(min = 3,max = 5)
    private int repeat;

    @Override
    public void sayQuote() {
        for (int i = 0; i < repeat; i++) {
            System.out.println(message);
        }
    }
}
