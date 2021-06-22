package com.spring.project.bookforest.repository;

import com.spring.project.bookforest.domain.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {

    List<Product> findAllByNameContainingOrderByUpdatedAtAsc(String keyword);
    List<Product> findAllByCategoryContainingOrderByUpdatedAtAsc(String keyword);

    List<Product> findAllByNameContainingOrderByUpdatedAtDesc(String keyword);
    List<Product> findAllByCategoryContainingOrderByUpdatedAtDesc(String keyword);

    List<Product> findAllByNameContainingOrderByRateDesc(String keyword);
    List<Product> findAllByCategoryContainingOrderByRateDesc(String keyword);

    List<Product> findAllByNameContainingOrderByReviewCntDesc(String keyword);
    List<Product> findAllByCategoryContainingOrderByReviewCntDesc(String keyword);
}
