package com.spring.project.bookforest.domain.entity;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String picSrc;
    private int price;
    private int deliveryPrice;
    private int discountRate;
    private String category;
    private int stock;
    private String productDetail;

    private float rate = 0.0f;
    private int reviewCnt = 0;

    private LocalDateTime createdAt = LocalDateTime.now();
    private LocalDateTime updatedAt = LocalDateTime.now();

    @Builder
    public Product(String name, String picSrc,int price, int deliveryPrice, int discountRate, String category, int stock, String productDetail){
        this.name = name;
        this.picSrc = picSrc;
        this.price = price;
        this.deliveryPrice = deliveryPrice;
        this.discountRate = discountRate;
        this.category = category;
        this.stock = stock;
        this.productDetail = productDetail;
    }

    public void update(String name,String picSrc,int price, int deliveryPrice, int discountRate, String category, int stock, String productDetail){
        this.name = name;
        this.picSrc = picSrc;
        this.price = price;
        this.deliveryPrice = deliveryPrice;
        this. discountRate = discountRate;
        this.category = category;
        this.stock = stock;
        this.productDetail = productDetail;
        this.updatedAt = LocalDateTime.now();
    }
}
