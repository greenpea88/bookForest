package com.spring.project.bookforest.domain.service;

import com.spring.project.bookforest.domain.entity.Cart;
import com.spring.project.bookforest.domain.entity.Product;
import com.spring.project.bookforest.domain.entity.User;
import com.spring.project.bookforest.dto.CartResDto;
import com.spring.project.bookforest.repository.CartRepository;
import com.spring.project.bookforest.repository.ProductRepository;
import com.spring.project.bookforest.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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

    public List<CartResDto> getCartList(String email, int page){
        PageRequest pageRequest = PageRequest.of(page,10);
        List<Cart> result = cartRepository.findAllByUserEmail(pageRequest,email);

        List<CartResDto> cartResDtoList = new ArrayList<>();
        for (Cart r: result){
            cartResDtoList.add(entityToDto(r));
        }
        return cartResDtoList;
    }

    public void deleteFromCart(Long pId){
        Cart cart = cartRepository.getById(pId);
    }

    private CartResDto entityToDto(Cart cart){
        return new CartResDto(cart.getProduct().getName(),cart.getProduct().getPicSrc(),cart.getNum());
    }
}
