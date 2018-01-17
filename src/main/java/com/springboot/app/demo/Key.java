package com.springboot.app.demo;

import java.util.ArrayList;
import java.util.List;
/**
 * @ClassName: Key
 * @Description: idea快捷键
 * @author: chenliang
 * @date: 12/22/17 8:41 AM
 */
public class Key {

    private static String name; //修改name变量名 fn+shift+f6

    //提取静态变量alt+comm+c
    public static final String LIANG = "chen";

    public static void main(String[] args) {
        List<String> list = new ArrayList<String>();
        fa(list);//自动生成fa方法 alt+enter

        sayHello(name, "111");//fn+comm+f6
    }

    //方法重构
    private static void sayHello(String name, String address) {


        //提取字符变量 alt+comm+v
        String cen = "chen";
        System.out.println(cen);
        System.out.println(cen);
        System.out.println(cen);
        System.out.println(cen);


        System.out.println(LIANG);
        System.out.println(LIANG);
        System.out.println(LIANG);
        System.out.println(LIANG);
        System.out.println(LIANG);
    }

    private static void fa(List<String> li) {

        //自动生成for循环：li.for选择
        for (int i = 0; i < li.size(); i++) {

        }

        //代码重构 alt+enter
        for (String iterm : li) {
        }

    }


}
