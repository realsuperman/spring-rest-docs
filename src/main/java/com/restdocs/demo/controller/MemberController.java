package com.restdocs.demo.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class MemberController {
    @GetMapping
    public String getTest(){
        return "ok";
    }

    @PostMapping
    public String postTest(){
        return "ok";
    }
}
