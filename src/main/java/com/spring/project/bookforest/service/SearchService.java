package com.spring.project.bookforest.service;

import com.spring.project.bookforest.domain.entity.Product;
import com.spring.project.bookforest.dto.ProductResDto;
import com.spring.project.bookforest.domain.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class SearchService {

    private final ProductRepository productRepository;

    public List<ProductResDto> searchProduct(String keyword, String sorting, int page){
        //product name과 category에서 keyword 모두 검색
        List<Product> result = new ArrayList<>();
        //page는 0이 1페이지
        PageRequest pageRequest = PageRequest.of(page,10);
        switch (sorting){
            case "recent":
                result = productRepository.findAllByNameContainingOrCategoryContainingOrderByUpdatedAtAsc(pageRequest,keyword);
                break;
            case "old":
                result = productRepository.findAllByNameContainingOrCategoryContainingOrderByUpdatedAtDesc(pageRequest, keyword);
                break;
            case "rate":
                result = productRepository.findAllByNameContainingOrCategoryContainingOrderByRateDesc(pageRequest, keyword);
                break;
            case "review":
                result = productRepository.findAllByNameContainingOrCategoryContainingOrderByReviewCntDesc(pageRequest,keyword);
                break;

        }
        List<ProductResDto> resDtoList = new ArrayList<>();
        for (Product r: result){
            resDtoList.add(entityToDto(r));
        }
        return resDtoList;
   }

   private ProductResDto entityToDto(Product product){
        return new ProductResDto(product.getId(),product.getName(),product.getPicSrc()
                ,product.getPrice(),product.getRate(),product.getReviewCnt(),product.getCategory());
   }
}
