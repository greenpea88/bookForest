package com.spring.project.bookforest.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ProductUpdateReqDto {

    private Long id;
    private String name;
    private String picSrc;
    private int price;
    private int deliveryPrice;
    private int discountRate;
    private String category;
    private int stock;
    private String productDetail;

    @Override
    public String toString() {
        return "ProductUpdateReqDto{" +
                "pId=" + id +
                ", name='" + name + '\'' +
                ", picSrc='" + picSrc + '\'' +
                ", price=" + price +
                ", deliveryPrice=" + deliveryPrice +
                ", discountRate=" + discountRate +
                ", category='" + category + '\'' +
                ", stock=" + stock +
                ", productDetail='" + productDetail + '\'' +
                '}';
    }
}
