package com.qiwi.my_spring;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author Evgeny Borisov
 */
public class ObjectFactoryTest {

    @Test
    public void testInjectRandomIntIsWorking() {
        Elf elf = ObjectFactory.getInstance().createObject(Elf.class);
        System.out.println(elf);
        assertNotEquals(0, elf.getPower());
        assertNotEquals(0, elf.getSpeed());
        assertEquals(0, elf.getAge());

    }
}