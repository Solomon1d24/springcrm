package com.solomon.springcrm.Aspect;


import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

@Component
@Aspect
@EnableAspectJAutoProxy(exposeProxy = true, proxyTargetClass = true)
public abstract class AbstractAspect {


    @Pointcut("execution(* com.solomon.springcrm.DaoImpl.*.*(..))")
    public void forDaoPackage() {
    }

    @Pointcut("execution(* com.solomon.springcrm.Model.*.*(..))")
    public void forModelPackage() {
    }

    @Pointcut("execution(* com.solomon.springcrm.ServiceImpl.*.*(..))")
    public void forServicePackage() {
    }

    @Pointcut("execution(* com.solomon.springcrm.*.*.get*(..))")
    public void forGetterMethod() {
    }

    @Pointcut("execution(* com.solomon.springcrm.*.*.set*(..))")
    public void forSetterMethod() {
    }

    @Pointcut("execution(* com.solomon.springcrm.*.*.delete*(..))")
    public void forDeleteMethod() {
    }

    @Pointcut("execution(* com.solomon.springcrm.*.*.save*(..))")
    public void forSaveMethod() {
    }

    @Pointcut("execution(* com.solomon.springcrm.*.*.update*(..))")
    public void forUpdateMethod() {
    }

    @Pointcut("execution(* com.solomon.springcrm.*.*.get*(..))")
    public void forGetMethod() {
    }


}
