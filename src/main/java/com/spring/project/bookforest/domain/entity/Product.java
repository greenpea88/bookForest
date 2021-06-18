package com.spring.project.bookforest.domain.entity;

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
    private Long pId;

    private String name;
    private int price;
    private int deliveryPrice;
    private int discountRate;
    private String category;
    private int stock;
    private String productDetail;

    private float rate;
    private int reviewCnt;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
