package com.spring.project.bookforest.controller.api;

import com.spring.project.bookforest.dto.ReviewWriteReqDto;
import com.spring.project.bookforest.service.ReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/review")
@RequiredArgsConstructor
public class ReviewController {

    private final ReviewService reviewService;

    //리뷰 작성
    @PostMapping("/write_review")
    public void writeReview(@RequestBody ReviewWriteReqDto reqDto){
        reviewService.writeReview(reqDto);
    }

    //리뷰 수정
    @PutMapping("/modify_review")
    public void modifyReview(){

    }

    //리뷰 삭제
    @PutMapping("/delete_review")
    public void deleteReview(){

    }

    //리뷰 리스트 가져오기
    @GetMapping("/get_reviewList")
    public void getReviewList(){

    }
}
