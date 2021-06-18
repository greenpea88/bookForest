package com.spring.project.bookforest.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class UserInfoDto {

    private String email;
    private String name;
    private String password;
    private String phoneNumber;

    private String addr1;
    private String addr2;
    private String addrCode;

    private String uClass;
    private int purchaseAmount;
}
