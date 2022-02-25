package com.qiwi.tdd;

import lombok.SneakyThrows;

/**
 * @author Evgeny Borisov
 */
public class NdsResolverImpl implements NdsResolver {


    private double nds;

    public NdsResolverImpl() {
        nds = getFromWebService();
    }

    @SneakyThrows
    private double getFromWebService() {
        Thread.sleep(5000);
        return  0.22;
    }



    @Override
    public double resolveNds() {
        return nds;
    }
}
