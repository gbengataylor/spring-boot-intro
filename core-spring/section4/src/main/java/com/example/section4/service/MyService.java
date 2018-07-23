package com.example.section4.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class MyService {

    @Value("${my.msg}")
    private String myMesg;

   public String myMessage() {
        return myMesg;
    }
}
