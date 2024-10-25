package com.estsoft.springproject.blog.controller;

import com.estsoft.springproject.blog.domain.Comment;
import com.estsoft.springproject.blog.domain.dto.CommentRequestDTO;
import com.estsoft.springproject.blog.domain.dto.ComnnetResponseDTO;
import com.estsoft.springproject.blog.repository.CommentRepositoty;
import com.estsoft.springproject.blog.service.CommentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class ComnnetArticleController {

    private final CommentService commentService;

    public ComnnetArticleController(CommentService commentService) {
        this.commentService = commentService;
    }

    // POST localhost:8080/api/articles/{{articleId}}comments
    @PostMapping(value = "/api/articles/{{articleId}}comments", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ComnnetResponseDTO> saveCommentByArticleId(@PathVariable Long articleId,
                                                                     @RequestBody CommentRequestDTO request) {
       Comment comment = commentService.saveCommnet(articleId, request);
       return ResponseEntity.status(HttpStatus.CREATED).body(new ComnnetResponseDTO(comment));
    }

    @GetMapping("/api/comment/{commentId}")
    public ResponseEntity<ComnnetResponseDTO> selectCommentById(@PathVariable Long commentId) {
        Comment comment = commentService.findComment(id);
        return ResponseEntity.ok(new CommentResponseDTO(comment));
    }

    @PutMapping("/api/comments/{commentId}")
    public ResponseEntity<CommentRequestDTO> updateCommentById(@PathVariable Long commentId,
                                                               @RequestBody CommentRequestDTO request) {
        Comment updated = commentService.update(commentId, request);
        return ResponseEntity.ok(new CommentResponseDTO(updated));
    }

}
