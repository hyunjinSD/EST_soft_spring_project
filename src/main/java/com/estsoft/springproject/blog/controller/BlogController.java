package com.estsoft.springproject.blog.controller;

import com.estsoft.springproject.blog.domain.dto.AddArticleRequest;
import com.estsoft.springproject.blog.domain.Article;
import com.estsoft.springproject.blog.domain.dto.ArticleResponse;
import com.estsoft.springproject.blog.domain.dto.UpdateArticleRequest;
import com.estsoft.springproject.blog.service.BlogService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api")
public class BlogController {
    private final BlogService service;
    public BlogController(BlogService service) {
        this.service = service;
    }

    //    @RequestMapping(method = RequestMethod.POST, value = "/articles")
    @PostMapping("/articles")
    public ResponseEntity<ArticleResponse> writeArticle(@RequestBody AddArticleRequest request) {
        log.info("request: {}, {}", request.getTitle(), request.getContent());
        Article article = service.saveArticle(request);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(article.convert());
    }

    // Request Mapping   조회 : HTTP METHOD? GET
    @GetMapping("/articles")
    public ResponseEntity<List<ArticleResponse>> findAll() {
//        List<Article> articleList = service.findAll();

        // List<Article> -> List<ArticleResponse> 로 변환해서 응답으로 보내기
        List<ArticleResponse> list = service.findAll().stream()
                .map(Article::convert)
                .toList();
        return ResponseEntity.ok(list);
    }

    // 단건 조회 API (Request mapping) 만들기  GET //articles/1  , /articles/{}
    @GetMapping("/articles/{id}")
    public ResponseEntity<ArticleResponse> findById(@PathVariable Long id){
        Article article = service.findBy(id); // Exception (5xx sever error) -> 4xx Status Code
        // Article -> ArticleResponse
        return ResponseEntity.ok(article.convert());
    }

    // DELETE /articles/{id}
//  밑에랑 동일 @RequestMapping(method = RequestMethod.DELETE, value = "/articles/{id}")
    @DeleteMapping("/articles/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id){
        service.deleteBy(id);
        return ResponseEntity.ok().build();
    }

    // PUT /article/ {id} 수정 API body
    @PutMapping("/articles/{id}")
    public ResponseEntity<ArticleResponse> updateById(@PathVariable Long id,
                                                      @RequestBody UpdateArticleRequest request) {
        Article updatedArticle = service.update(id, request);
        return ResponseEntity.ok(updatedArticle.convert());
    }

    // reference : https://docs.spring.io/spring-framework/reference/web/webmvc/mvc-controller/ann-exceptionhandler.html
    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<String> handleIllegalArgumentException(IllegalArgumentException e) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage()); // reason : ""
    }
}