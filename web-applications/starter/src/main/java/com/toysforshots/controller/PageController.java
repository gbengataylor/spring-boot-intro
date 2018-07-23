package com.toysforshots.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
//@RestController
public class PageController {
    @RequestMapping("/")
    public String home() {
        return "hello"; // as a @controller this won't work as it's trying to return a view
    }
}
