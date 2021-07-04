package com.spring.project.bookforest.service;

import com.spring.project.bookforest.domain.entity.Product;
import com.spring.project.bookforest.domain.entity.Review;
import com.spring.project.bookforest.domain.entity.User;
import com.spring.project.bookforest.domain.repository.ProductRepository;
import com.spring.project.bookforest.domain.repository.ReviewRepository;
import com.spring.project.bookforest.domain.repository.UserRepository;
import com.spring.project.bookforest.dto.ReviewProductResDto;
import com.spring.project.bookforest.dto.ReviewUserResDto;
import com.spring.project.bookforest.dto.ReviewUpdateReqDto;
import com.spring.project.bookforest.dto.ReviewWriteReqDto;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ReviewService {

    private final ReviewRepository reviewRepository;
    private final UserRepository userRepository;
    private final ProductRepository productRepository;

    public void writeReview(ReviewWriteReqDto reqDto){
        //TODO: review title 10자 이하 예외처리
        User user = userRepository.findByEmail(reqDto.getUserEmail());
        Product product = productRepository.findById(reqDto.getProductId()).orElse(null);

        reviewRepository.save(Review.builder().title(reqDto.getTitle()).rate(reqDto.getRate())
                .content(reqDto.getContent()).user(user).product(product).build());
    }

    public void updateReview(ReviewUpdateReqDto reqDto){
        Review review = reviewRepository.findById(reqDto.getId()).orElse(null);
        review.update(reqDto.getTitle(),reqDto.getRate(),reqDto.getContent());

        reviewRepository.save(review);
    }

    public void deleteReview(Long id){
        Review review = reviewRepository.getById(id);
        review.setDeleted(true);

        reviewRepository.save(review);
    }

    public List<ReviewUserResDto> getReviewUserList(int page, String email){
        PageRequest pageRequest = PageRequest.of(page,10);
        List<Review> result = reviewRepository.findAllByUserEmailAndDeletedFalse(pageRequest, email);

        List<ReviewUserResDto> reviewUserResDtoList = new ArrayList<>();
        for (Review r: result){
            reviewUserResDtoList.add(entityToUserDto(r));
        }
        return reviewUserResDtoList;
    }

    public List<ReviewProductResDto> getReviewProductList(int page, Long productId){
        PageRequest pageRequest = PageRequest.of(page, 5);
        List<Review> result = reviewRepository.findAllByProductIdAndDeletedFalse(pageRequest, productId);

        List<ReviewProductResDto> reviewProductResDtoList = new ArrayList<>();
        for (Review r: result){
            reviewProductResDtoList.add(entityToProductDto(r));
        }
        return reviewProductResDtoList;
    }

    private ReviewUserResDto entityToUserDto(Review review){
        return new ReviewUserResDto(review.getId(),review.getTitle(),review.getRate()
                ,review.getContent(),review.getProduct().getId());
    }

    private ReviewProductResDto entityToProductDto(Review review){
        return new ReviewProductResDto(review.getId(),review.getTitle(),review.getRate(),review.getContent());
    }
}
