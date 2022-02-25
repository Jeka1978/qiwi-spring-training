package com.qiwi.tdd;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.*;

/**
 * @author Evgeny Borisov
 */
public class TaxCalculatorTest {

    @Test
    public void withNds() {

        NdsResolver mock = Mockito.mock(NdsResolver.class);
        Mockito.when(mock.resolveNds()).thenReturn(0.2);

        TaxCalculator calculator = new TaxCalculator(mock);
        double withNds = calculator.withNds(100);
        Assert.assertEquals(120,withNds,0.0000001);
    }
}