package com.spring.project.bookforest.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ReviewUpdateReqDto {

    private Long id;
    private String title;
    private int rate;
    private String content;
}
