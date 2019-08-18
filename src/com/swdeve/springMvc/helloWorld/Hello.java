package com.swdeve.springMvc.helloWorld;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller //不可省略
public class Hello {

    public Hello(){
//        System.out.println("初始化Hello");
    }
    //访问路径  http://localhost:8080/hello
    @RequestMapping(value = "/hello")
    public String hello(){
        System.out.println("进入hello方法");
        //该success是直接作为字符串到返回是视图的路径上的
        return "success";
    }
}