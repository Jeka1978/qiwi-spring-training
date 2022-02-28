package com.qiwi.real_spring;

import lombok.Setter;

import javax.annotation.PostConstruct;
import java.util.List;

/**
 * @author Evgeny Borisov
 */
public class TalkingRobot {
    @Setter
    private List<Quoter> quoters;


    @PostConstruct
    public void talk() {
        quoters.forEach(Quoter::sayQuote);
    }
}








