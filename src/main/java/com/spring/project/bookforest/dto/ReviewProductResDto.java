package com.spring.project.bookforest.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReviewProductResDto {
    Long id;
    String title;
    int rate;
    String content;
}
