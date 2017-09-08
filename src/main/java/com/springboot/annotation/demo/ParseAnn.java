package com.springboot.annotation.demo;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

/**
 * Created by Administrator on 2017/9/3 0003.
 */
public class ParseAnn {
    public static void main(String[] args) {
        //1:加载类
        try {
            Class c = Class.forName("com.springboot.annotation.demo.Child");

            //2：找到类上面注解
            boolean isExist = c.isAnnotationPresent(Description.class);
            if (isExist) {
                //3:获取注解实例
                Description description = (Description) c.getAnnotation(Description.class);

                System.out.println(description.value());
            }



            //4:找到方法上的注解
            Method[] ms = c.getMethods();
            for (Method method : ms) {
                isExist = method.isAnnotationPresent(Description.class);
                if (isExist) {
                    Description description1 =method.getAnnotation(Description.class);
                    System.out.println(description1.value());
                }
            }

            //另一种解析方法
            for (Method method : ms) {
                Annotation[] annotations =  method.getAnnotations();
                for (Annotation annotation : annotations) {
                    if (annotation instanceof Description) {
                        Description description1 = (Description) annotation;
                        System.out.println(description1.value());
                    }
                }
            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }



    }
}
