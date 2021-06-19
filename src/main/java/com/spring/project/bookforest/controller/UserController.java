package com.spring.project.bookforest.controller;

import com.spring.project.bookforest.domain.service.UserService;
import com.spring.project.bookforest.dto.*;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/register") //회원가입
    public void userRegister(@RequestBody UserRegisterReqDto requestDto){
        //TODO: response IS_CREATE로 변경하기
        //TODO: 사용자 존재 여부 확인
        //TODO: 비밀번호 암호화
        userService.userRegister(requestDto);
    }

    @PostMapping("/login") //로그인
    public UserLoginResDto login(@RequestBody UserLoginReqDto reqDto){
        return userService.login(reqDto);
    }

    //TODO: 로그아웃
    public void logout(){

    }

    @GetMapping("/info")
    public UserInfoDto getUserInfo(@RequestParam String email){
        return userService.getUserInfo(email);
    }

    @PutMapping("/info")
    public UserInfoDto updateUserInfo(@RequestBody UserUpdateReqDto requestDto){
        //비밀번호, 전화번호, 주소만 변경 가능
        return userService.updateUserInfo(requestDto);
    }

    @GetMapping("/update_verify")
    public boolean verifyToUpdate(@RequestParam String email, @RequestParam String password){
        //TODO: password 값이 유효하면 true return
        //TODO: password 암호화해서 받기
        return userService.verifyToUpdate(email,password);
    }

    @PutMapping("/inc_purchase")
    public void incPurchase(String email,int price){
        userService.incPurchase(email,price);
    }

    @PutMapping("dec_purchase")
    public void decPurchase(String email,int price){
        userService.decPurchase(email,price);
    }
}
