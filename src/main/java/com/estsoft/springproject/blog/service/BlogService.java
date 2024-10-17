package com.estsoft.springproject.blog.service;

import com.estsoft.springproject.blog.domain.dto.AddArticleRequest;
import com.estsoft.springproject.blog.domain.Article;
import com.estsoft.springproject.blog.domain.dto.UpdateArticleRequest;
import com.estsoft.springproject.blog.repository.BlogRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

    // blog 게시글 단건 조회 id(PK) 1건
    public Article findBy(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("not found id: " + id));
    }

    // blog 게시글 삭제 (id)
    public void deleteBy(Long id){
            repository.deleteById(id);
    }

    @Transactional
    public Article update(Long id, UpdateArticleRequest request) {
        Article article = findBy(id);  // 수정하고 싶은 (article객체) 가져옴
        article.update(request.getTitle(), request.getContent());
        return article;
    }
}
