package com.spring.project.bookforest.service;

import com.spring.project.bookforest.domain.entity.Product;
import com.spring.project.bookforest.domain.entity.Review;
import com.spring.project.bookforest.domain.entity.User;
import com.spring.project.bookforest.domain.repository.ProductRepository;
import com.spring.project.bookforest.domain.repository.ReviewRepository;
import com.spring.project.bookforest.domain.repository.UserRepository;
import com.spring.project.bookforest.dto.ReviewUpdateReqDto;
import com.spring.project.bookforest.dto.ReviewWriteReqDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

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
}
