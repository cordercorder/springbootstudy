package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
//@Controller
@RequestMapping("/hello")//给整个类指定url

public class HelloController {
//    @Value("${Test}")
//    private String Test;
//
//    @Value("${age}")
//    private int a;
//
//    @Value("${content}")
//    private String s;
    @Autowired
    private BoyProperties boyProperties;

    @GetMapping(value = "/hello")//组合注解简化书写
//    @PostMapping
//    @RequestMapping(value = {"/hello/{id}","/hi/{id}"},method = RequestMethod.GET)//访问两个url,method这里可以什么都不写
    public String say(){
//        return "Hello Spring Boot!";
//        return Test+a;
//        return s;
//        return "id: "+id;
//        return "index";
        return boyProperties.ch;
    }
    public String f(){
        return "ninini";
    }
}
