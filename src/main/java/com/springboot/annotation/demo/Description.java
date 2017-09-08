package com.springboot.annotation.demo;

import java.lang.annotation.*;

/**
 * Created by Administrator on 2017/9/3 0003.
 */
@Target({ElementType.TYPE, ElementType.METHOD}) //注解作用域 类 方法 参数上
@Retention(RetentionPolicy.RUNTIME) //生命周期：源码（source）、编译（class）、运行（RUNTIME）
@Inherited //只能继承类注解
@Documented
public @interface Description {

//    public String desc();
//
//    public String author();
//
//    public int age() default 18;

    public String value();
}
