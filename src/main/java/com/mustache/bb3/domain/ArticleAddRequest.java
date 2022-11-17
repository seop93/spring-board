package com.mustache.bb3.domain;

import com.mustache.bb3.domain.entity.Article;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@Getter
@AllArgsConstructor
@EqualsAndHashCode
public class ArticleAddRequest {
    private String title;
    private String content;

    public Article toEntity() {

        Article article = Article.builder()
                .title(getTitle())
                .content(getContent())
                .build();
        return article;
    }
}
