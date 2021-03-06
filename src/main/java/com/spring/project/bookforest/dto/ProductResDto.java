package com.spring.project.bookforest.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductResDto {

    private Long pId;
    private String name;
    private String picSrc;
    private int price;
    private float rate;
    private int reviewCnt;
    private String category;
}
