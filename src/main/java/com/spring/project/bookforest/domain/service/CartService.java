package com.spring.project.bookforest.domain.service;

import com.spring.project.bookforest.domain.entity.Cart;
import com.spring.project.bookforest.domain.entity.Product;
import com.spring.project.bookforest.domain.entity.User;
import com.spring.project.bookforest.repository.CartRepository;
import com.spring.project.bookforest.repository.ProductRepository;
import com.spring.project.bookforest.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CartService {

    private final CartRepository cartRepository;
    private final UserRepository userRepository;
    private final ProductRepository productRepository;

    public void putCart(String email, Long pId, int num){
        User user = userRepository.findByEmail(email);
        System.out.println(user);
        //TODO: 존재하지 않는 물건일 경우 예외처리
        Product product = productRepository.findById(pId).orElse(null);
        Cart cart = Cart.builder().user(user).product(product).num(num).build();
        System.out.println(cart);
        cartRepository.save(Cart.builder().user(user).product(product).num(num).build());
    }
}
