package com.mustache.bb3.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mustache.bb3.domain.ArticleAddRequest;
import com.mustache.bb3.domain.ArticleAddResponse;
import com.mustache.bb3.domain.dto.ArticleDto;
import com.mustache.bb3.domain.entity.Article;
import com.mustache.bb3.service.ArticleService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(ArticleRestController.class)
class ArticleRestControllerTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    ArticleService articleService;

    @Autowired
    ObjectMapper objectMapper;


    @Test
    @DisplayName("해당 id의 글이 조회가 잘 되는지")
    void findSingle() throws Exception {
        Long id = 1l;

        given(articleService.getArticleById(id))
                .willReturn(new ArticleDto(1l, "첫번째 글", "내용입니다."));

        mockMvc.perform(get("/api/v1/articles/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").exists())
                .andExpect(jsonPath("$.title").exists())
                .andExpect(jsonPath("$.content").exists())
                .andDo(print());

        verify(articleService).getArticleById(id);
    }

    @Test
    @DisplayName("추가 잘되는지")
    void add() throws Exception {
        ArticleAddRequest dto = new ArticleAddRequest("제목입니다", "내용입니다.");

        given(articleService.add(dto)).willReturn(new ArticleAddResponse(1l, dto.getTitle(), dto.getContent()));

        mockMvc.perform(post("/api/v1/articles")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsBytes(new ArticleAddRequest("제목입니다", "내용입니다.")))
                )
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").exists())
                .andExpect(jsonPath("$.title").exists())
                .andExpect(jsonPath("$.content").exists())
                .andDo(print());

        verify(articleService).add(dto);
    }

}