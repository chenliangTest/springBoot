package com.springboot.singleton;

/**
 * Created by Administrator on 2017/9/17 0017.
 * 饿汉模式
 */
public class Singleton_1 {

    //构造方法私有化，不允许外边直接创建对象
    private Singleton_1(){}

    //创建类的实例
    private static Singleton_1 singleton1 = new Singleton_1();

    //对外提供获取实例方法
    public static Singleton_1 getInstance(){
        return singleton1;
    }


}
