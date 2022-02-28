package com.qiwi.real_spring;

import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.List;

/**
 * @author Evgeny Borisov
 */
@Component("tr")
public class TalkingRobot {


    @Film
    private List<Quoter> quoters;

    @PostConstruct
    public void talk() {
        quoters.forEach(Quoter::sayQuote);
    }
}








