package com.spring.project.bookforest.controller.api;

import com.spring.project.bookforest.service.SearchService;
import com.spring.project.bookforest.dto.ProductResDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/search")
@RequiredArgsConstructor
@Slf4j
public class SearchController {

    private final SearchService searchService;

    //keyword search - default sort = recent
    @GetMapping
    public List<ProductResDto> searchProduct(@RequestParam String keyword,
                                             @RequestParam int page,
                                             @RequestParam(defaultValue = "recent") String sorting){
        //parameter로 sorting 방법 받음
        //soring - default(=recent), recent, old, review, rate
        //TODO: paging
        return searchService.searchProduct(keyword,sorting, page);
    }

}
