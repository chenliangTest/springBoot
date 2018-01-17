package com.springboot.app.contorll;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserContorll {

    @GetMapping(value = "/getUser")
    public void queryUserList(){

        System.out.println("查询用户信息");
    }
}
