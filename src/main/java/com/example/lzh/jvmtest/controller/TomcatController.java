package com.example.lzh.jvmtest.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("tomcat")
public class TomcatController {

    @RequestMapping("hello")
    public String hello(){
        String string="";

        for (int i=0;i<10;i++){
            string+=i;
        }
    return string;
    }

}
