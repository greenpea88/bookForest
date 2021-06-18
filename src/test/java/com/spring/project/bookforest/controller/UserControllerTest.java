package com.spring.project.bookforest.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.spring.project.bookforest.dto.UserRegisterReqDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@WebMvcTest
class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void register() throws Exception {
        UserRegisterReqDto reqDto = new UserRegisterReqDto("green_pea88@naver.com","greenpea",
                "123456","010-1111-2222");

        String json = new ObjectMapper().writeValueAsString(reqDto);

        mockMvc.perform(
                MockMvcRequestBuilders.post("http://localhost:8080/user/sign_in")
                .contentType(MediaType.APPLICATION_JSON)
                .content(json)
        ).andExpect(
                MockMvcResultMatchers.status().isOk()
        ).andDo(MockMvcResultHandlers.print());
    }

    @Test
    public void getInfo() throws Exception {

        mockMvc.perform(
                MockMvcRequestBuilders.get("http://localhost:8080/user/info")
                .queryParam("email","green_pea88")
        ).andExpect(
                MockMvcResultMatchers.status().isOk()
        ).andDo(MockMvcResultHandlers.print());
    }
}