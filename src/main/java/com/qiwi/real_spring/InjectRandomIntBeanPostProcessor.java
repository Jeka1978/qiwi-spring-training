package com.qiwi.real_spring;

import com.qiwi.my_spring.InjectRandomIntAnnotationObjectConfigurator;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

/**
 * @author Evgeny Borisov
 */
@Component
public class InjectRandomIntBeanPostProcessor implements BeanPostProcessor {

    private InjectRandomIntAnnotationObjectConfigurator configurator = new InjectRandomIntAnnotationObjectConfigurator();

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        configurator.configure(bean);
        return bean;
    }

}



