package com.spring.project.bookforest.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class UserUpdateReqDto {

    //email은 수정 불가 -> column 찾기에 사용
    private String email;
    private String password;
    private String phoneNumber;

    private String addr1;
    private String addr2;
    private String addrCode;
}
