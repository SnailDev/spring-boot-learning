package com.example.springbootredis.controller;

import com.example.springbootredis.domain.User;
import com.example.springbootredis.domain.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.UUID;

/**
 * @Author: ming.zhao
 * @Date: 2018-10-05 21:01
 */
@RestController
public class UserController {
    @Autowired
    private UserRepository userRepository;

    @GetMapping("/getUser")
    @Cacheable(value = "user-key")
    public User getUser() {
        User user = userRepository.findUserByUserName("bb1");
        System.out.println("若下面没出现“无缓存的时候调用”字样且能打印出数据表示测试成功");

        return user;
    }

    @GetMapping("/uid")
    public String uid(HttpSession session) {
        UUID uid = (UUID) session.getAttribute("uid");
        if (uid == null) {
            uid = UUID.randomUUID();
        }
        session.setAttribute("uid", uid);
        return session.getId();
    }
}
