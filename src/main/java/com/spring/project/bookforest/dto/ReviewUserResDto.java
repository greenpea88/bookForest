package com.spring.project.bookforest.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReviewUserResDto {

    Long id;
    String title;
    int rate;
    String content;

    Long productId;
}
