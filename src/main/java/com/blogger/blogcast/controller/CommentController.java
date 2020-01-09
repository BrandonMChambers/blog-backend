package com.blogger.blogcast.controller;

import com.blogger.blogcast.model.Comment;
import com.blogger.blogcast.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Note: might simplify these endpoints to retrieve comments
 * without requiring blogId or blogEntryId.
 * if commentId is universally unique, then other ids are not needed to identify a Comment
 *
 *
 */
@CrossOrigin(origins = "*")
@RestController
public class CommentController {
    @Autowired
    private CommentService commentService;

    @GetMapping(value = "/comments")
    public ResponseEntity<Iterable<Comment>> getAllComments() {
        return commentService.getAllComments();
    }

    /**
     *  To access endpoint, POST JSON {"body": body, "authorId": authorId, "blogEntryId": blogEntryId}
     *  must include blogEntryId, so that the comment can be linked to a particular entry
     *
     *  Sample JSON for posting Comment
     *  {
     * 	"body": "hello world",
     * 	"authorId": 4,
     * 	"blog_entry_id": 3
     * }
     *
     * may refactor later
     */

    @PostMapping(value = "/comments")
    public ResponseEntity<Comment> postComment(@RequestBody Comment comment) {
        return commentService.postCommentOnBlogEntry(comment.getBlogEntryId(), comment);
    }

    @GetMapping(value = "/comments/{commentId}")
    public ResponseEntity<Comment> getCommentById(@PathVariable Long commentId) {
        return commentService.getCommentById(commentId);
    }

    /**
     * Sample JSON for putting Comment
     *  {"body": "edited a comment"}
     */

    @PutMapping(value = "/comments/{commentId}")
    public ResponseEntity<Comment> updateComment(@PathVariable Long commentId, @RequestBody Comment comment) {
        return commentService.updateComment(commentId, comment);
    }

    @DeleteMapping(value = "/comments/{commentId}")
    public ResponseEntity<Boolean> deleteComment(@PathVariable Long commentId) {
        return commentService.deleteComment(commentId);
    }

    @GetMapping(value = "/comments/entry/{entryId}")
    public ResponseEntity<Iterable<Comment>> getCommentsByEntryId(@PathVariable Long entryId) {
        return commentService.getAllCommentsForBlogEntry(entryId);
    }
}
