package com.bw.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope
public class TextController {
    @Value("${myNameKey:zhangsan}")
    private String myName;
    @Autowired
    Student student;
    @RequestMapping("test")
    public String ta(){
        return "Mytext333";
    }
    @RequestMapping("list")
    public  String text(){
        return myName;
    }
    @RequestMapping("stu")
    public  Student text1(){
        return student;
    }
}
