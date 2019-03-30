package com.example.demo.controller;


import com.example.demo.domain.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/user")

public class UserController {
    @Autowired
    private UserService userService;
    @GetMapping("add")
    public String add(){
        User user=new User();
        user.setUsername("hello");
        user.setPassword("090909");
        user.setContent("This is a test");
        userService.add(user);
        return "add success";
    }
}
