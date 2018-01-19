package com.springboot.app.aspect;

import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * @ClassName: HttpAspect
 * @Description: aop给所有方法执行前添加判断，是否登录
 * @author: chenliang
 * @date: 2018/1/17 下午3:43
 */
@Aspect
@Component
public class HttpAspect {

    private static Logger logger  = LoggerFactory.getLogger(HttpAspect.class);

    @Pointcut("execution(public * com.springboot.app.contorll.*.*(..))")
    public void log(){

    }

    @Before("log()")
    public void doBefore(){
        logger.info("11111115555");
    }

    @After("log()")
    public void doAfter(){
        logger.info("222222233333");
    }

//    @AfterReturning
//    public void doAfterReturning(){
//
//    }
}
