package com.solomon.springcrm.Aspect;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Component
@Aspect
@EnableAspectJAutoProxy(proxyTargetClass = true, exposeProxy = true)
public class ServiceAspect extends AbstractAspect {

    private static Logger myLogger = Logger.getLogger(ServiceAspect.class.getName());


    @Pointcut("forServicePackage() && forGetMethod()")
    public void forServiceGetPointcut() {
    }


    @Pointcut("forServicePackage() && forSaveMethod()")
    public void forServiceSavePointcut() {
    }


    @Pointcut("forServicePackage() && forUpdateMethod()")
    public void forServiceUpdatePointcut() {
    }


    @Pointcut("forServicePackage() && forDeleteMethod()")
    public void forServiceDeletePointcut() {
    }

    @Before("forServiceGetPointcut()")
    public void beforeGetMethod(JoinPoint joinPoint) {
        myLogger.info(">> Executing the get method: " + joinPoint.getSignature().toShortString());
    }

    @Before("forServiceSavePointcut()")
    public void beforeSaveMethod(JoinPoint joinPoint) {
        myLogger.info(">> Executing the save method: " + joinPoint.getSignature().toShortString());
    }

    @Before("forServiceUpdatePointcut()")
    public void beforeUpdateMethod(JoinPoint joinPoint) {
        myLogger.info(">> Executing the update method: " + joinPoint.getSignature().toShortString());
    }

    @Before("forServiceUpdatePointcut()")
    public void beforeDeleteMethod(JoinPoint joinPoint) {
        myLogger.info(">> Executing the delete method: " + joinPoint.getSignature().toShortString());
    }


}
