package com.example.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @RequestMapping("/test")
    public String hello(){
        System.out.println("TestController的方法被调用了");
        return "welcom to the new page";
    }
}
