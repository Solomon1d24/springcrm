package com.solomon.springcrm.Aspect;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Component
@EnableAspectJAutoProxy(proxyTargetClass = true, exposeProxy = true)
@Aspect
public class DaoAspect extends AbstractAspect {

    private static Logger myLogger = Logger.getLogger(DaoAspect.class.getName());

    @Pointcut("forDaoPackage() && forSaveMethod()")
    public void DaoSavePointcut() {
    }

    @Pointcut("forDaoPackage() && forGetMethod()")
    public void DaoGetPointcut() {

    }

    @Pointcut("forDaoPackage() && forDeleteMethod()")
    public void DaoDeletePointcut() {

    }

    @Pointcut("forDaoPackage() && forUpdateMethod()")
    public void DaoUpdatePointcut() {

    }

    @Before("DaoSavePointcut()")
    public void forDaoSaveMethod(JoinPoint joinPoint) {
        Object[] args = joinPoint.getArgs();
        myLogger.info(">> The arguements are: ");
        for(Object obj : args){
            myLogger.info(obj.toString());
        }
        myLogger.info(">> Executing the save method : " + joinPoint.getSignature().toShortString());
    }

    @Before("DaoGetPointcut()")
    public void forDaoGetMethod(JoinPoint joinPoint) {
        myLogger.info(">> Executing the get method : " + joinPoint.getSignature().toShortString());
    }


    @Before("DaoDeletePointcut()")
    public void forDaoDeleteMethod(JoinPoint joinPoint) {
        myLogger.info(">> Executing the delete method : " + joinPoint.getSignature().toShortString());
    }


    @Before("DaoUpdatePointcut()")
    public void forDaoUpdateMethod(JoinPoint joinPoint) {
        myLogger.info(">> Executing the update method : " + joinPoint.getSignature().toShortString());
    }

    @AfterReturning(value = "DaoGetPointcut()", returning = "result")
    public void afterDaoGetMethod(JoinPoint joinPoint, Object result){
        String signature = joinPoint.getSignature().toShortString();

        myLogger.info(">> in @AfterReturning method: " + signature);

        myLogger.info(">> The result is : " + result);

    }


}
