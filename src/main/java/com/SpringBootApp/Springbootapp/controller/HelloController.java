package com.SpringBootApp.Springbootapp.controller;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @Value("${message.welcome}")
    public String welcomeMessage;
    @GetMapping("/")
    public String helloWorld(){
        return  welcomeMessage;
    }
}