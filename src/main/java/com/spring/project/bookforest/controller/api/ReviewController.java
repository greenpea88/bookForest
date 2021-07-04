package com.spring.project.bookforest.controller.api;

import com.spring.project.bookforest.dto.ReviewProductResDto;
import com.spring.project.bookforest.dto.ReviewUpdateReqDto;
import com.spring.project.bookforest.dto.ReviewUserResDto;
import com.spring.project.bookforest.dto.ReviewWriteReqDto;
import com.spring.project.bookforest.service.ReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    @PutMapping("/update_review")
    public void updateReview(@RequestBody ReviewUpdateReqDto reqDto){
        reviewService.updateReview(reqDto);
    }

    //리뷰 삭제
    @PutMapping("/delete_review")
    public void deleteReview(@RequestParam Long id){
        reviewService.deleteReview(id);
    }

    //리뷰 리스트 가져오기 - 사용자
    @GetMapping("/get_userReviews")
    public List<ReviewUserResDto> getReviewUserList(@RequestParam int page, @RequestParam String email){
        return reviewService.getReviewUserList(page, email);
    }

    //리뷰리스트 가져오기 - 물건
    @GetMapping("/get_productReviews")
    public List<ReviewProductResDto> getReviewProductList(@RequestParam int page, @RequestParam Long productId){
        return reviewService.getReviewProductList(page,productId);
    }
}
