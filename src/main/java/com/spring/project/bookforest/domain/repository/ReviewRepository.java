package com.spring.project.bookforest.domain.repository;

import com.spring.project.bookforest.domain.entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepository extends JpaRepository<Review,Long> {
}
