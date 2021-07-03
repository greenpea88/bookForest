package com.spring.project.bookforest.controller.api;

import com.spring.project.bookforest.service.CartService;
import com.spring.project.bookforest.dto.CartResDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    @PutMapping("/delete_product")
    public void deleteProduct(@RequestParam Long cId){
        cartService.deleteFromCart(cId);
    }

    //장바구니 리스트 불러오기
    @GetMapping("/get_cart_list")
    public List<CartResDto> getCartList(@RequestParam String email, @RequestParam int page){
        return cartService.getCartList(email,page);
    }

    //담은 물건 수량 변경
    @PutMapping("/modify_num")
    public void modifyProductNum(@RequestParam Long pId, @RequestParam int num){

    }
}