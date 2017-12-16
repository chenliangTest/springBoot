package com.springboot.singleton;

/**
 * Created by Administrator on 2017/9/17 0017.
 */
public class SingletonTest {

    public static void main(String[] args) {
        Singleton_1 singleton1 = Singleton_1.getInstance();
        Singleton_1 singleton11 = Singleton_1.getInstance();
        if (singleton1 == singleton11) {
            System.out.println("singleton1 == singleton11");
        } else {
            System.out.println("singleton1 ！= singleton11");
        }


        Singleton_2 singleton2 = Singleton_2.getInstance();
        Singleton_2 singleton21 = Singleton_2.getInstance();
        if (singleton2 == singleton21) {
            System.out.println("singleton2 == singleton21");
        }else {
            System.out.println("singleton2 ！= singleton21");
        }
    }
}
