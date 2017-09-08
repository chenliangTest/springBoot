package com.springboot.annotation.demo_1;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by Administrator on 2017/9/3 0003.
 */
public class Test {

    public static String query(Object filter){

        StringBuffer sb = new StringBuffer();

        //1:获取到class
        Class c = filter.getClass();

        //2:获取table的名字
        boolean isExist = c.isAnnotationPresent(Table.class);
        if (!isExist) {
            return  null;
        }

        Table table = (Table) c.getAnnotation(Table.class);
        String tableName = table.value();
        sb.append("select * from ").append(tableName).append(" where 1=1");

        //3遍历所用字段
        Field[] fields = c.getDeclaredFields();
        for (Field field :fields) {
            //获取字段名字
            isExist = field.isAnnotationPresent(Column.class);
            if (!isExist) {
                continue;
            }

            Column column = field.getAnnotation(Column.class);
            String columnName = column.value();

            //获取字段值
            String fieldName = field.getName();
            String getMethodName = "get"+fieldName.substring(0,1).toUpperCase()+fieldName.substring(1);

            Object fieldValue = null ;
            try {
                Method getMetod = c.getMethod(getMethodName);
                fieldValue = getMetod.invoke(filter);
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }

            if (fieldValue == null || (fieldValue instanceof  Integer && (Integer)fieldValue == 0)) {
                continue;
            }

            //拼装sql
            sb.append(" and ").append(fieldName);
            if (fieldValue instanceof String) {
                if (((String) fieldValue).contains(",")) {
                    String[] strings = ((String) fieldValue).split(",");
                    sb.append("in(");
                    for (String s : strings) {
                        sb.append("'").append(s).append("'").append(",");
                    }
                    sb.deleteCharAt(sb.length()-1);
                    sb.append(")");
                } else {
                    sb.append("=").append("'").append(fieldValue).append("'");
                }

            } else {
                sb.append(" and ").append(fieldName).append("=").append(fieldValue);
            }


        }


        return  sb.toString();
    }

    public static void main(String[] args) {

        Filter f1 = new Filter();
        f1.setId(10);

        Filter f2 = new Filter();
        f2.setUserNmae("chenliang");

        Filter f3 = new Filter();
        f3.setEmail("chen@126.com,liang@163.com");

        Filter_1 f4 = new Filter_1();
        f4.setId(20);
        f4.setUserNmae("chen");

        String sql1 = query(f1);
        String sql2 = query(f2);
        String sql3 = query(f3);
        String sql4 = query(f4);

        System.out.println(sql1);
        System.out.println(sql2);
        System.out.println(sql3);
        System.out.println(sql4);



    }


}
