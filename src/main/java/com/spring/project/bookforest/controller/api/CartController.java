package com.spring.project.bookforest.controller.api;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/cart")
public class CartController {

    //장바구니 담기
    @PostMapping("/put_product")
    public void putProduct(){

    }

    //장바구니 빼기
    @DeleteMapping("/delete_product")
    public void deleteProduct(){

    }

    //장바구니 리스트 불러오기
    @GetMapping("/get_cart_list")
    public void getCartList(){

    }

    //담은 물건 수량 변경
    @PutMapping("/modify_num")
    public void modifyProductNum(){

    }
}