package com.estsoft.springproject.blog.service;

import com.estsoft.springproject.blog.domain.AddArticleRequest;
import com.estsoft.springproject.blog.domain.Article;
import com.estsoft.springproject.blog.repository.BlogRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class BlogService {
    private final BlogRepository repository;

    public BlogService(BlogRepository repository) {
        this.repository = repository;
    }

    // Blog 게시글 저장
    // repository.save(Article)

    public Article saveArticle(AddArticleRequest request) {
        // 요청 txId: 1
//        log.warn("{} 반드시 서버에서 확인해야 하는 값 : {}",txId, 1);

        return repository.save(request.toEntity());
    }

    // blog 게시글 조회
    public List<Article> findAll() {
        return repository.findAll();
    }
}
