package com.swdeve.springMvc.helloWorld.dao;


import org.springframework.stereotype.Repository;

@Repository
public class UserDao {

    public UserDao(){
        System.out.println("初始化UserDao....");
    }
}
