package com.springboot.annotation.demo_1;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by Administrator on 2017/9/3 0003.
 */
@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME) //生命周期：源码（source）、编译（class）、运行（RUNTIME）
public @interface Table {

    String value();
}
