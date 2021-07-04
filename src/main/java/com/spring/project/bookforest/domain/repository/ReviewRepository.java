package com.spring.project.bookforest.domain.repository;

import com.spring.project.bookforest.domain.entity.Review;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReviewRepository extends JpaRepository<Review,Long> {

    List<Review> findAllByUserEmailAndDeletedFalse(Pageable pageable, String email);
}
