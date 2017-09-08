package com.springboot.annotation.demo;

/**
 * Created by Administrator on 2017/9/3 0003.
 */
@Description("I am class") //单个参数
public class Child implements Person {

    @Override
//    @Description(desc="chen",author="liang") 多个注解参数
    @Description("I am method") //单个参数
    public String name() {
        return null;
    }

    @Override
    public int age() {
        return 0;
    }
}
