package com.mustache.bb3.domain.dto;


import com.mustache.bb3.domain.Article;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class ArticleDto {

    private Long id;
    private String title;
    private String content;

    public Article toEntity(){
        return new Article(this.id,this.title, this.content);
    }


}
