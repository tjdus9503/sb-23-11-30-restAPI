package com.ll.sb231130restapi.domain.article.article.dto;

import com.ll.sb231130restapi.domain.article.article.entity.Article;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class ArticleDto {
    private final Long id;
    private final LocalDateTime createDate;
    private final LocalDateTime modifyDate;
    private final Long authorId;
    private final String authorName;
    private final String title;
    private final String body;

    public ArticleDto(Article article) {
        id = article.getId();
        createDate = article.getCreateDate();
        modifyDate = article.getModifyDate();
        authorId = article.getAuthor().getId();
        authorName = article.getAuthor().getName();
        title = article.getTitle();
        body = article.getBody();
    }
}
