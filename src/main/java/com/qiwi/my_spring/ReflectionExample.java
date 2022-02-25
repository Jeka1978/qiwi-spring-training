package com.qiwi.my_spring;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

/**
 * @author Evgeny Borisov
 */
public class ReflectionExample {

    public void discoverMetadata(Object o) {

        Class<?> type = o.getClass();
        int modifiers = type.getModifiers();
        boolean aFinal = Modifier.isFinal(modifiers);
        String className = type.getName();
        Constructor<?>[] constructors = type.getConstructors();
        Method[] methods = type.getMethods();
        Field[] fields = type.getDeclaredFields();
    }

    public void manipulateObjects(Object o) {
        Class<?> type = o.getClass();
//        type.getDeclaredField("fieldName")
        Field[] fields = type.getDeclaredFields();
        fields[0].setAccessible(true);
//        fields[0].set(o,"someData");
//        type.getMethod("").invoke(o)
    }

    public void createObjects(Class<?> type) {
//        type.getDeclaredConstructor().newInstance()
    }


    public void loadClass(String className) {
//        Class<?> type = Class.forName(className);
    }


























}
