package com.spring.project.bookforest.controller;

import com.spring.project.bookforest.domain.service.UserService;
import com.spring.project.bookforest.dto.UserInfoDto;
import com.spring.project.bookforest.dto.UserRegisterReqDto;
import com.spring.project.bookforest.dto.UserUpdateReqDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/register")
    public void userRegister(@RequestBody UserRegisterReqDto requestDto){
        //TODO: response IS_CREATE로 변경하기
        userService.userRegister(requestDto);
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

}
