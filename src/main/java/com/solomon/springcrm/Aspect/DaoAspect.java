package com.solomon.springcrm.Aspect;


import org.aspectj.lang.annotation.Aspect;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

@Component
@EnableAspectJAutoProxy(proxyTargetClass = true, exposeProxy = true)
@Aspect
public class DaoAspect extends AbstractAspect{


}
