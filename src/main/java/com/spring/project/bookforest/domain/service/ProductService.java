package com.spring.project.bookforest.domain.service;

import com.spring.project.bookforest.domain.entity.Product;
import com.spring.project.bookforest.dto.ProductUploadReqDto;
import com.spring.project.bookforest.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    //물건 등록
    public void uploadProduct(ProductUploadReqDto reqDto){
        productRepository.save(Product.builder()
                .name(reqDto.getName())
                .picSrc(reqDto.getPicSrc())
                .price(reqDto.getPrice())
                .deliveryPrice(reqDto.getDeliveryPrice())
                .discountRate(reqDto.getDiscountRate())
                .category(reqDto.getCategory())
                .stock(reqDto.getStock())
                .productDetail(reqDto.getProductDetail())
                .build());
    }

    //물건 정보 수정
    public void updateProduct(Product product){
        Product modify = productRepository.findById(product.getPId()).orElse(null);
        modify.update(product.getName(),product.getPicSrc(),product.getPrice()
                ,product.getDeliveryPrice(), product.getDiscountRate(),product.getCategory()
                ,product.getStock(),product.getProductDetail());

        productRepository.save(modify);
    }
}
