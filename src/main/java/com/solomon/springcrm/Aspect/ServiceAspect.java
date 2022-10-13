package com.solomon.springcrm.Aspect;


import org.aspectj.lang.annotation.Aspect;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

@Component
@Aspect
@EnableAspectJAutoProxy(proxyTargetClass = true, exposeProxy = true)
public class ServiceAspect extends AbstractAspect {
}
