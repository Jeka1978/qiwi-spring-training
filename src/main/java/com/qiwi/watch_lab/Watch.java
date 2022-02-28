package com.qiwi.watch_lab;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author Evgeny Borisov
 */
@Component
public class Watch {

    @Autowired
    private List<Regime> regimes;

    private int index;

    @Autowired
    private Regime currentRegime;

    public void a() {
        currentRegime.a();
    }

    public void b() {
        currentRegime.b();
    }

    public void nextRegime() {
        index++;
        if (index == regimes.size()) {
            index=0;
        }
        currentRegime = regimes.get(index);
    }


}

