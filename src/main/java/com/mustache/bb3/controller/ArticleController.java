package com.mustache.bb3.controller;

import com.mustache.bb3.domain.entity.Article;
import com.mustache.bb3.domain.dto.ArticleDto;
import com.mustache.bb3.repository.ArticleRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/articles")
@Slf4j
public class ArticleController {

    private final ArticleRepository articleRepository;

    public ArticleController(ArticleRepository articleRepository) {
        this.articleRepository = articleRepository;
    }


    @GetMapping("")
    public String listPage(Model model){
        List<Article> articles = articleRepository.findAll();
        model.addAttribute("articles", articles);
        return "articles/list";
    }

    @GetMapping("/new")
    public String createArticlePage(){
        return "articles/new";
    }

    @PostMapping("")
    public String createArticle(ArticleDto articleDto){

        Article savedArticle = articleRepository.save(articleDto.toEntity());
        return String.format("redirect:/articles/%d",savedArticle.getId());
    }

    @GetMapping("/{id}")
    public String showSingle(@PathVariable Long id, Model model){
        Optional<Article> optionalArticle = articleRepository.findById(id);
        if(!optionalArticle.isEmpty()) {
            model.addAttribute("article", optionalArticle.get());
            return "articles/show";
        }
            return "error";

    }

    @GetMapping(value = "/{id}/edit")
    public String edit(@PathVariable Long id, Model model) {
        Optional<Article> optionalArticle = articleRepository.findById(id);

        if(!optionalArticle.isEmpty()){
            model.addAttribute("article", optionalArticle.get());
            return "articles/edit";
        } else {
            model.addAttribute("message", String.format("%d가 없습니다.", id));
            return "error";
        }
    }

    @PostMapping("/{id}/update")
    public String update(@PathVariable Long id, ArticleDto articleDto, Model model){
        log.info("title:{} content:{}",articleDto.getTitle(),articleDto.getContent());
        Article article = articleRepository.save(articleDto.toEntity());
        model.addAttribute("article", article);
        return String.format("redirect:/articles/%d", article.getId());
    }




}
