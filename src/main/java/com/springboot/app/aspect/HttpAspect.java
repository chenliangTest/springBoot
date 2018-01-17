package com.springboot.app.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class HttpAspect {

    @Before("execution(public * com.springboot.app.contorll.*(..))")
    public void log(){
        System.out.println("请登录！！");
    }
}
