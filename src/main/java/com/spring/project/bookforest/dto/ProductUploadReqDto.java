package com.spring.project.bookforest.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ProductUploadReqDto {

    private String name;
    private String picSrc;
    private int price;
    private int deliveryPrice;
    private int discountRate;
    private String category;
    private int stock;
    private String productDetail;
}
