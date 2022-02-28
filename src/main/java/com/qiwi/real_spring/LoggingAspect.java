package com.qiwi.real_spring;

import lombok.SneakyThrows;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

/**
 * @author Evgeny Borisov
 */
@Component
@Aspect
public class LoggingAspect {


    @Around("@annotation(com.qiwi.my_spring.Loggable)")
    @SneakyThrows
    public Object handleLoggableMethods(ProceedingJoinPoint pjp) {
        System.out.println("method "+pjp.getSignature().getName()+" started");
       /* try {
            pjp.proceed();
        } catch (Throwable e) {
            e.printStackTrace();
            throw e;
        }*/


        Object retVal = pjp.proceed();

        System.out.println("method "+pjp.getSignature().getName()+" ended");
        return retVal;
    }

}
