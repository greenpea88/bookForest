package com.spring.project.bookforest.dto;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public class CartResDto {

    private Long pId;
    private String productName;
    private String productPicSrc;
    private int num;
}
