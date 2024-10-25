package com.estsoft.springproject.blog.service;

import com.estsoft.springproject.blog.domain.Article;
import com.estsoft.springproject.blog.domain.Comment;
import com.estsoft.springproject.blog.domain.dto.CommentRequestDTO;
import com.estsoft.springproject.blog.repository.BlogRepository;
import com.estsoft.springproject.blog.repository.CommentRepositoty;
import org.springframework.stereotype.Controller;

import java.util.Optional;

@Controller
public class CommentService {
    private final BlogRepository blogRepository;
    private final CommentRepositoty commentRepositoty;

    public CommentService(BlogRepository blogRepository) {
        this.blogRepository = blogRepository;
        this.commentRepositoty = commentRepository;
    }

    public Comment saveCommnet(Long articleId, CommentRequestDTO requestDTO) {
        Article article = blogRepository.findById(articleId).orElseThrow();
        return commentRepository.save(new Comment(requestDTO.getBody(), article));
    }

    public Comment findComment(Long commentId) {
        Optional<Comment> optionalComment = commentRepositoty.findById(commentId);
        return optionalComment.orElse(new Comment());
//        return commentRepositoty.findById(commentId);
    }

    public update(Long commentId, CommentRequestDTO request) {
        Comment comment = commentRepository.findById(commentId).orElseThrow();
        // 수정
        comment.updateCommentBody(request.getBody());

        return commentRepositoty.save(comment);
    }
}
