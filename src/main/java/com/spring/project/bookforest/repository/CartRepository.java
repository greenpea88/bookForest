package com.spring.project.bookforest.repository;

import com.spring.project.bookforest.domain.entity.Cart;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CartRepository extends JpaRepository<Cart, Long> {

    List<Cart> findAllByUserEmail(PageRequest page, String email);
}
