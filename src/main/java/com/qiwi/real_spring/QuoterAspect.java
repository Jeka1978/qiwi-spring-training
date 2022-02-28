package com.qiwi.real_spring;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

/**
 * @author Evgeny Borisov
 */
@Component
@Aspect
public class QuoterAspect {

    //5 JPoint Before, After, AfterThrowing, AfterReturning, Around

    @Before("execution(* com.qiwi..*.say*(..))")
    public void handleSayMethods(JoinPoint jp) {
        String simpleName = jp.getTarget().getClass().getSimpleName();
        System.out.println(simpleName + " Это сказал:  ");
    }

}
