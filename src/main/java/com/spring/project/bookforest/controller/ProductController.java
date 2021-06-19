package com.spring.project.bookforest.controller;

import com.spring.project.bookforest.domain.entity.Product;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/product")
public class ProductController {

    @PostMapping("/upload")
    public void uploadProduct(@RequestBody Product product){
        
    }
}
