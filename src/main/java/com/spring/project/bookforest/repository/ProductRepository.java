package com.spring.project.bookforest.repository;

import com.spring.project.bookforest.domain.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
