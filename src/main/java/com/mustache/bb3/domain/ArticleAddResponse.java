package com.mustache.bb3.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ArticleAddResponse {

    private Long id;
    private String title;
    private String content;
}
