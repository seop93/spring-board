package com.mustache.bb3.domain.entity;


import com.mustache.bb3.domain.dto.ArticleDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Entity
@Getter
@Table(name = "article4")
@NoArgsConstructor
@AllArgsConstructor
public class Article {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String content;

//    public Article(){
//
//    }
    public Article(String title, String content){
        this.title = title;
        this.content = content;
    }

    public static ArticleDto of(Article article){

        return new ArticleDto(article.getId(), article.getTitle(), article.getContent());
    }
}
