package com.qiwi.my_spring;

/**
 * @author Evgeny Borisov
 */
public class ObjectFactory {

    private static ObjectFactory instance = new ObjectFactory();

    private ObjectFactory() {
    }

    public static ObjectFactory getInstance() {
        return instance;
    }

    public <T> T createObject(Class<T> type) {
      //todo handle: type can be both class and interface as well
    }
}








