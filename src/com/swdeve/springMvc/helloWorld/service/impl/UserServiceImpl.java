package com.swdeve.springMvc.helloWorld.service.impl;

import com.swdeve.springMvc.helloWorld.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    public UserServiceImpl(){
        System.out.println("初始化UserServiceImpl...");
    }

    @Override
    public void test() {
        System.out.println("进入UserServiceImpl 的 test 方法");
    }
}
