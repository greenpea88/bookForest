package com.spring.project.bookforest.controller.api;

import com.spring.project.bookforest.domain.service.CartService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/cart")
@RequiredArgsConstructor
public class CartController {

    private final CartService cartService;

    //장바구니 담기
    @PostMapping("/put_product")
    public void putProduct(@RequestParam String email, @RequestParam Long pId, @RequestParam int num){
        cartService.putCart(email,pId,num);
    }

    //장바구니 빼기
    @DeleteMapping("/delete_product")
    public void deleteProduct(){

    }

    //장바구니 리스트 불러오기
    @GetMapping("/get_cart_list")
    public void getCartList(@RequestParam String email, @RequestParam int page){

    }

    //담은 물건 수량 변경
    @PutMapping("/modify_num")
    public void modifyProductNum(){

    }
}