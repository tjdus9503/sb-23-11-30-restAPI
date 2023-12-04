package com.ll.sb231130restapi.domain.article.article.controller;

import com.ll.sb231130restapi.domain.article.article.dto.ArticleDto;
import com.ll.sb231130restapi.domain.article.article.service.ArticleService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/articles")
@RequiredArgsConstructor
public class ApiV1ArticlesController {

    private final ArticleService articleService;

    @GetMapping("")
    public List<ArticleDto> getArticles() {
        return articleService
                .findAll()
                .stream()
                .map(article -> new ArticleDto(article))
                .toList();
    }
}
