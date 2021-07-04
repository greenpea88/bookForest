package com.spring.project.bookforest.service;

import com.spring.project.bookforest.domain.entity.Product;
import com.spring.project.bookforest.domain.entity.Review;
import com.spring.project.bookforest.domain.entity.User;
import com.spring.project.bookforest.domain.repository.ProductRepository;
import com.spring.project.bookforest.domain.repository.ReviewRepository;
import com.spring.project.bookforest.domain.repository.UserRepository;
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
        System.out.println(user);
        Product product = productRepository.findById(reqDto.getProductId()).orElse(null);
        System.out.println(product);

        reviewRepository.save(Review.builder().title(reqDto.getTitle()).rate(reqDto.getRate())
                .content(reqDto.getContent()).user(user).product(product).build());
    }
}
