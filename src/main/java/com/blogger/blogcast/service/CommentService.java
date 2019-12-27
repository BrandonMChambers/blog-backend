package com.blogger.blogcast.service;

import com.blogger.blogcast.model.Comment;
import com.blogger.blogcast.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@Service
public class CommentService {
    @Autowired
    private CommentRepository commentRepository;

    public ResponseEntity<Iterable<Comment>> getAllComments() {
        Iterable<Comment> comments = commentRepository.findAll();
        return new ResponseEntity<>(comments, HttpStatus.OK);
    }

    public ResponseEntity<Iterable<Comment>> getAllCommentsForBlogEntry(Long blogEntryId) {
        Iterable<Comment> comments = commentRepository.findCommentsByBlogEntry(blogEntryId);
        return new ResponseEntity<>(comments, HttpStatus.OK);
    }

    public ResponseEntity<Comment> postCommentOnBlogEntry(Long blogEntryId, Comment comment) {
        comment.setBlog_entry_id(blogEntryId);
        // TODO: generate timestamp at time of creation
        comment = commentRepository.save(comment);
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.setLocation(ServletUriComponentsBuilder.fromCurrentRequest().path("/{blogEntryId}").buildAndExpand(comment.getBlog_entry_id()).toUri());
        return new ResponseEntity<>(null, responseHeaders, HttpStatus.CREATED);
    }

    public ResponseEntity<Comment> getCommentById(Long commentId) {
        Comment comment = commentRepository.findById(commentId).get();
        return new ResponseEntity<>(comment, HttpStatus.OK);
    }

    public ResponseEntity<Comment> updateComment(Long commentId, Comment comment) {
        Comment original = commentRepository.findById(commentId).get();
        // TODO: generate new timestamp at time of edit
        original.setBody(comment.getBody());
        //maybe set <edited> flag to true
        original = commentRepository.save(original);
        return new ResponseEntity<>(null, HttpStatus.OK);
    }

    public ResponseEntity<Boolean> deleteComment(Long commentId) {
        commentRepository.deleteById(commentId);
        return new ResponseEntity<>(true, HttpStatus.OK);
    }

}
