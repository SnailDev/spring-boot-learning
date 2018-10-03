package com.example.web.controller;

import com.example.web.domain.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: ming.zhao
 * @Date: 2018-10-03 16:26
 */
@RestController
public class HelloWorldController {
    @GetMapping("/getUser")
    public User getUser(){
        User user = new User();
        user.setUserName("snaildev");
        user.setPassword("123456");
        return user;
    }
}
