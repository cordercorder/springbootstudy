package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
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

    @RequestMapping(value = "/hello",method = RequestMethod.GET)
    public int say(){
//        return "Hello Spring Boot!";
//        return Test+a;
//        return s;
        return boyProperties.getScore();
    }

}
