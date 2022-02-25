package com.qiwi.my_spring;

import lombok.SneakyThrows;
import org.reflections.Reflections;

import java.lang.invoke.SerializedLambda;
import java.util.Set;

/**
 * @author Evgeny Borisov
 */
public class ObjectFactory {

    private static ObjectFactory instance = new ObjectFactory();
    private Config config = new JavaConfig();
    private Reflections scanner = new Reflections("com.qiwi");

    private ObjectFactory() {
    }

    public static ObjectFactory getInstance() {
        return instance;
    }

    @SneakyThrows
    public <T> T createObject(Class<T> type) {
        type = resolveImple(type);
        T t = type.getDeclaredConstructor().newInstance();


        return t;


    }

    private <T> Class<T> resolveImple(Class<T> type) {
        if (type.isInterface()) {
            Class<? extends T> implClass = config.getImplClass(type);
            if (implClass == null) {
                Set<Class<? extends T>> classes = scanner.getSubTypesOf(type);
                if (classes.size() != 1) {
                    throw new IllegalStateException(type + " 0 or more than one impl found,update your config");
                }
                implClass= classes.iterator().next();
            }
            type = (Class<T>) implClass;

        }
        return type;
    }
}








