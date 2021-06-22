package com.spring.project.bookforest.domain.service;

import com.spring.project.bookforest.domain.entity.Product;
import com.spring.project.bookforest.dto.ProductSearchResDto;
import com.spring.project.bookforest.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class SearchService {

    private final ProductRepository productRepository;

    public List<ProductSearchResDto> searchProduct(String keyword, String sorting){
        //product name과 category에서 keyword 모두 검색
        List<Product> result_name = new ArrayList<>();
        List<Product> result_category = new ArrayList<>();
        switch (sorting){
            case "recent":
                productRepository.findAllByNameContainingOrderByUpdatedAtAsc(keyword);
                productRepository.findAllByCategoryContainingOrderByUpdatedAtAsc(keyword);
                break;
            case "old":
                productRepository.findAllByNameContainingOrderByUpdatedAtDesc(keyword);
                productRepository.findAllByCategoryContainingOrderByUpdatedAtDesc(keyword);
                break;
            case "rate":
                productRepository.findAllByNameContainingOrderByRateDesc(keyword);
                productRepository.findAllByCategoryContainingOrderByRateDesc(keyword);
                break;
            case "review":
                productRepository.findAllByNameContainingOrderByReviewCntDesc(keyword);
                productRepository.findAllByCategoryContainingOrderByReviewCntDesc(keyword);
                break;

        }
        List<ProductSearchResDto> resDtoList = new ArrayList<>();
        for (Product r: result_name){
            resDtoList.add(entityToDto(r));
        }
        for (Product r: result_category){
            resDtoList.add(entityToDto(r));
        }
        return resDtoList;
   }

   private ProductSearchResDto entityToDto(Product product){
        return new ProductSearchResDto(product.getPId(),product.getName(),product.getPicSrc(),product.getPrice(),product.getRate(),product.getReviewCnt());
   }
}
