package com.springboot.app.contorll;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName: UserContorll
 * @Description: 用户信息
 * @author: chenliang
 * @date: 2018/1/17 下午3:39
 */
@RestController
public class UserControll {

    @GetMapping(value = "/getUser")
    public void queryUserList(){

        System.out.println("查询用户信息");
    }
}
