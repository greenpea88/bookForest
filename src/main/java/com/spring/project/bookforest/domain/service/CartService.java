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
        //TODO: 존재하지 않는 물건일 경우 예외처리
        Cart cart;
        List<Cart> result = cartRepository.findAllByUserEmailAndProductId(email,pId);
        if(result == null){
            //cart에 존재하지 않는 상품
            User user = userRepository.findByEmail(email);
            Product product = productRepository.findById(pId).orElse(null);
            cart = Cart.builder().user(user).product(product).num(num).build();
        }
        else{
            //cart에 이미 존재하는 상품
            cart = result.get(0); //pid가 같은 상품은 email당 한 개만 존재
            cart.setNum(cart.getNum()+num);
        }
        cartRepository.save(cart);
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

    public void deleteFromCart(Long cId){
//        List<Cart> deleteCart = cartRepository.findAllByUserEmailAndProductId(email,pId);
//        cartRepository.deleteByCId(deleteCart.get(0).getCId());
        cartRepository.deleteByCId(cId);
    }

    public void modifyCartNum(Long cId, int num){

    }

    private CartResDto entityToDto(Cart cart){
        return new CartResDto(cart.getProduct().getId(), cart.getProduct().getName()
                ,cart.getProduct().getPicSrc(),cart.getNum());
    }
}
