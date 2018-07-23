package com.therealdanvega;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PageController {

    @Value("${pageController.msg}")
    private         String pageControllerFlag;

    @Value("${my.secret}")
    private         String secret;

    @RequestMapping("/")
    public String map() {
        return pageControllerFlag+secret;
    }
}
