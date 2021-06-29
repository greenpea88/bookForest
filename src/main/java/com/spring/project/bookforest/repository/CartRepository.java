package com.spring.project.bookforest.repository;

import com.spring.project.bookforest.domain.entity.Cart;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CartRepository extends JpaRepository<Cart, Long> {

    List<Cart> findAllByUserEmail(Pageable page, String email);
//    List<Cart> findAllByUserEmailAndProductPId(String email, Long pId);
}
