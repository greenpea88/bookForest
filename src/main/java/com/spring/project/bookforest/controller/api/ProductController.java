package com.spring.project.bookforest.controller.api;

import com.spring.project.bookforest.domain.entity.Product;
import com.spring.project.bookforest.domain.service.ProductService;
import com.spring.project.bookforest.dto.ProductResDto;
import com.spring.project.bookforest.dto.ProductUploadReqDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    public void updateProduct(@RequestBody Product reqDto){
        productService.updateProduct(reqDto);
    }

    @GetMapping("/product_list")
    public List<ProductResDto> getProductList(@RequestParam int page){
        return productService.getProductList(page);
    }


}
