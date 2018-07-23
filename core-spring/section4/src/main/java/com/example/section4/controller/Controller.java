package com.example.section4.controller;

import com.example.section4.service.MyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {
    @Value("${my.config}")
    private String value;

    @Autowired
    public void setMyService(MyService myService) {
        this.myService = myService;
    }

    private MyService myService;


    @RequestMapping("/")
    public String method() {
        return value;
    }

    @RequestMapping("/message")
    public String message() {
        return myService.myMessage();
    }
}
