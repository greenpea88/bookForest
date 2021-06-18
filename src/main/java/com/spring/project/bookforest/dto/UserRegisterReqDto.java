package com.spring.project.bookforest.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class UserRegisterReqDto {
    //회원가입 시 필요 정보 : email, name, pw, phone number
    private String email;
    private String name;
    private String password;
    private String phoneNumber;
}
