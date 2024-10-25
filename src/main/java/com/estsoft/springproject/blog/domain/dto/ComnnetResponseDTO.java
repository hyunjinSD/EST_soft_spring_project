package com.estsoft.springproject.blog.domain.dto;

import com.estsoft.springproject.blog.domain.Article;
import com.estsoft.springproject.blog.domain.Comment;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

//{
//        "id": 4,
//        "body": "댓글 내용1",
//        "createdAt": "2024-10-13 00:17:42",
//        "article":
//        }
@Getter
@Setter
@NoArgsConstructor
public class ComnnetResponseDTO {
    private Long commentId;
    private Long articleId;
    private String body;
    private LocalDateTime creatAt;
    private ArticleResponse article;

    public ComnnetResponseDTO(Comment comment) {
        Article articleFromComment = comment.getArticle();
        commentId = comment.getId();
        articleId = articleFromComment.getId();
        body = comment.getBody();
        creatAt = comment.getCreatedAt();
        article = new ArticleResponse(comment.getArticle());
    }
}
