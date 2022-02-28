package com.qiwi.my_spring;

/**
 * @author Evgeny Borisov
 */
public interface ProxyConfigurator {
    Object wrapWithProxy(Object t, Class<?> type);
}
