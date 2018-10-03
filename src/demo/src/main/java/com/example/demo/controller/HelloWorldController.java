package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: ming.zhao
 * @Date: 2018-10-03 12:06
 */
@RestController
public class HelloWorldController {
    @GetMapping("/hello")
    public String index(){
        return "Hello World.";
    }
}
