package com.spring.project.bookforest.repository;

import com.spring.project.bookforest.domain.entity.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartRepository extends JpaRepository<Cart, Long> {
}
