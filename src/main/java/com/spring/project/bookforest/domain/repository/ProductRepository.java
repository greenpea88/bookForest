package com.spring.project.bookforest.domain.repository;

import com.spring.project.bookforest.domain.entity.Product;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {

    List<Product> findAllByNameContainingOrCategoryContainingOrderByUpdatedAtAsc(PageRequest page, String keyword);

    List<Product> findAllByNameContainingOrCategoryContainingOrderByUpdatedAtDesc(PageRequest page, String keyword);

    List<Product> findAllByNameContainingOrCategoryContainingOrderByRateDesc(PageRequest page, String keyword);

    List<Product> findAllByNameContainingOrCategoryContainingOrderByReviewCntDesc(PageRequest page, String keyword);

}
