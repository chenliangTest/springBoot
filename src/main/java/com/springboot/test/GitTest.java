package com.springboot.test;

/**
 * Created by Administrator on 2017/12/16.
 */
public class GitTest {

    public static void main(String[] args) {
        System.out.println("git 命令测试合并冲突");
        gitError();

        String ammount = "10.22";
        System.out.println(Float.valueOf(ammount));
        System.out.println(Float.parseFloat(ammount));

    }

    public static void gitError(){
        System.out.println("git 命令测试合并冲突111111");
        System.out.println("git 命令测试合并冲突22223333333");
        System.out.println("git 命令测试合并冲突444");
    }
}
