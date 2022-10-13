package com.solomon.springcrm.Aspect;


import org.aspectj.lang.annotation.Aspect;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

@Component
@Aspect
@EnableAspectJAutoProxy(exposeProxy = true, proxyTargetClass = true)
public class ModelAspect extends AbstractAspect {
}
