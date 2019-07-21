package com.pri.learningframe.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/test")
@RestController
public class TestController {


    @RequestMapping("/test01")
    public String test01(){
        int i = 2;
        int j = 2*i;
        if(j>i){
            System.out.println("j>i");
        }else {
            System.out.println("j>i");
        }
        return "success";
    }
}
