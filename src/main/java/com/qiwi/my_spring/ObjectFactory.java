package com.qiwi.my_spring;

import lombok.SneakyThrows;
import org.reflections.Reflections;

import java.lang.reflect.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * @author Evgeny Borisov
 */
public class ObjectFactory {

    private static ObjectFactory instance = new ObjectFactory();
    private Config config = new JavaConfig();
    private Reflections scanner = new Reflections("com.qiwi");
    private List<ObjectConfigurator> configurators = new ArrayList<>();

    @SneakyThrows
    private ObjectFactory() {
        Set<Class<? extends ObjectConfigurator>> classes = scanner.getSubTypesOf(ObjectConfigurator.class);
        for (Class<? extends ObjectConfigurator> aClass : classes) {
            if (!Modifier.isAbstract(aClass.getModifiers())) {
                configurators.add(aClass.getDeclaredConstructor().newInstance());
            }
        }
    }

    public static ObjectFactory getInstance() {
        return instance;
    }


    @SneakyThrows
    public <T> T createObject(Class<T> type) {
        type = resolveImple(type);

        T t = type.getDeclaredConstructor().newInstance();

        configure(t);

        invokeInit(type, t);

        if (type.isAnnotationPresent(Loggable.class)) {
            Object proxy = Proxy.newProxyInstance(type.getClassLoader(), type.getInterfaces(), new InvocationHandler() {
                @Override
                public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                    System.out.println("Logging for method " + method.getName() + " started");
                    Object retVal = method.invoke(t, args);

                    System.out.println("Logging for method " + method.getName() + " ended");
                    return retVal;
                }
            });
            return (T) proxy;
        }

        return t;


    }

    private <T> void invokeInit(Class<T> type, T t) throws IllegalAccessException, InvocationTargetException {
        Method[] methods = type.getMethods();
        for (Method method : methods) {
            if (method.getName().startsWith("init")) {
                method.invoke(t);
            }
        }
    }

    private <T> void configure(T t) {
        configurators.forEach(configurator -> configurator.configure(t));
    }

    private <T> Class<T> resolveImple(Class<T> type) {
        if (type.isInterface()) {
            Class<? extends T> implClass = config.getImplClass(type);
            if (implClass == null) {
                Set<Class<? extends T>> classes = scanner.getSubTypesOf(type);
                if (classes.size() != 1) {
                    throw new IllegalStateException(type + " 0 or more than one impl found,update your config");
                }
                implClass = classes.iterator().next();
            }
            type = (Class<T>) implClass;

        }
        return type;
    }
}








