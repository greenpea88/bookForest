package com.spring.project.bookforest.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ReviewWriteReqDto {

    String userEmail;
    Long productId;

    String title;
    int rate;
    String content;
}
