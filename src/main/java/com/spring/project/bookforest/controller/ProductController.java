package com.spring.project.bookforest.controller;

import com.spring.project.bookforest.domain.service.ProductService;
import com.spring.project.bookforest.dto.ProductUploadReqDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/product")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @PostMapping("/upload")
    public void uploadProduct(@RequestBody ProductUploadReqDto reqDto){
        productService.uploadProduct(reqDto);
    }

    @PutMapping("/update_info")
    public void updateProduct(@RequestBody ProductUploadReqDto reqDto){

    }

    @GetMapping("/product_list")
    public void getProductList(){

    }


}
