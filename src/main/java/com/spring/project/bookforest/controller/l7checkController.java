package com.spring.project.bookforest.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/l7check")
public class l7checkController {

    @GetMapping
    public String l7Check(){
        return " connection success";
    }
}
