package com.mustache.bb3.controller;

import com.mustache.bb3.domain.ArticleAddRequest;
import com.mustache.bb3.domain.ArticleAddResponse;
import com.mustache.bb3.domain.dto.ArticleDto;
import com.mustache.bb3.domain.entity.Article;
import com.mustache.bb3.repository.ArticleRepository;
import com.mustache.bb3.service.ArticleService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("api/v1/articles")
public class ArticleRestController {
    private final ArticleService articleService;

    public ArticleRestController(ArticleService articleService) {
        this.articleService = articleService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<ArticleDto> getArticle(@PathVariable Long id) {
        ArticleDto articleDto = articleService.getArticleById(id);
        return ResponseEntity.ok().body(articleDto);
    }

    @PostMapping
    public ResponseEntity<ArticleAddResponse> addArticle(@RequestBody ArticleAddRequest dto){
        ArticleAddResponse response = articleService.add(dto);
        return ResponseEntity.ok().body(response);
    }




}
