package com.qiwi.real_spring;

import com.qiwi.my_spring.InjectRandomInt;
import lombok.Setter;
import org.springframework.context.annotation.Lazy;

/**
 * @author Evgeny Borisov
 */

public class ShakespearQuoter implements Quoter {
    @Setter
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
