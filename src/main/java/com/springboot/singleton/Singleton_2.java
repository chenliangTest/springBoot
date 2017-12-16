package com.springboot.singleton;

/**
 * Created by Administrator on 2017/9/17 0017.
 * 懒汉模式
 */
public class Singleton_2 {

    //构造方法私有化，不允许外边直接创建对象
    private Singleton_2(){}

    //创建类的实例
    private static Singleton_2 singleton2;

    //对外提供获取实例方法
    public static Singleton_2 getInstance(){
        if (singleton2 == null){
            singleton2 = new Singleton_2();
        }
        return singleton2;
    }

}
