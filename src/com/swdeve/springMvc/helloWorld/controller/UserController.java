package com.swdeve.springMvc.helloWorld.controller;

import com.swdeve.springMvc.helloWorld.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserController {

    @Autowired
    UserService userService;
    public UserController(){
        System.out.println("初始化UserController...");
    }

    @RequestMapping(value="/testUser")
    public String test(){
        this.userService.test();
        return "success";
    }
}
