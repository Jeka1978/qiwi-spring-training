package com.qiwi.my_spring;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author Evgeny Borisov
 */
public class LoggableProxyConfigurator implements ProxyConfigurator {
    @Override
    public Object wrapWithProxy(Object t,Class<?> originalType) {


        if (originalType.isAnnotationPresent(Loggable.class)) {
            Object proxy = Proxy.newProxyInstance(originalType.getClassLoader(), originalType.getInterfaces(), new InvocationHandler() {
                @Override
                public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                    Method classMethod = originalType.getMethod(method.getName(), method.getParameterTypes());
                    if (classMethod.isAnnotationPresent(Loggable.class)) {
                        System.out.println("Logging for method " + method.getName() + " started");
                        Object retVal = method.invoke(t, args);

                        System.out.println("Logging for method " + method.getName() + " ended");
                        return retVal;
                    }else {
                        return method.invoke(t, args);
                    }
                }
            });
            return proxy;
        }else {
            return t;
        }
    }
}


