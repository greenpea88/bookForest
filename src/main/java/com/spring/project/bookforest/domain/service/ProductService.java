package com.spring.project.bookforest.domain.service;

import com.spring.project.bookforest.domain.entity.Product;
import com.spring.project.bookforest.dto.ProductResDto;
import com.spring.project.bookforest.dto.ProductUploadReqDto;
import com.spring.project.bookforest.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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

    public List<ProductResDto> getProductList(int page){
        PageRequest pageRequest = PageRequest.of(page,10);
        List<ProductResDto> resDtoList = new ArrayList<>();
        List<Product> result = productRepository.findAllByOrderByUpdatedAtAsc(pageRequest);
        for (Product r: result){
            resDtoList.add(entityToDto(r));
        }
        return resDtoList;
    }

    private ProductResDto entityToDto(Product product){
        return new ProductResDto(product.getPId(),product.getName(),product.getPicSrc()
                ,product.getPrice(),product.getRate(),product.getReviewCnt(),product.getCategory());
    }
}
