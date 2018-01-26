package com.springboot.javaBase;

import java.util.HashMap;
import java.util.Map;

public class Base {
    public static void main(String[] args) {

        /********************数据转换************************/

        String base = "10.11";
        System.out.println("String --> float-->Float.parseFloat():"+Float.parseFloat(base));
        System.out.println("String --> float-->Float.valueOf():"+Float.valueOf(base));


        String reverse = "abcdef";
        StringBuffer b = new StringBuffer(reverse);
        System.out.println("字符串反转-->StringBuffer.reverse():"+b.reverse());

        Map<String,String> map = new HashMap<String, String>();



    }
}
