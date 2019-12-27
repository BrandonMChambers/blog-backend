package com.blogger.blogcast.repository;

import com.blogger.blogcast.model.Comment;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * I need to tighten this up
 * the @Query annotation could probably be replaced with a fancy Spring method (long method name generated by spring)
 */

@Repository
public interface CommentRepository extends CrudRepository<Comment, Long> {
    @Query(value = "SELECT comment.* FROM comment, blog_entry WHERE blog_entry.BLOG_ENTRY_ID = ?1 AND comment.BLOG_ENTRY_ID = blog_entry.BLOG_ENTRY_ID", nativeQuery = true)
    Iterable<Comment> findCommentsByBlogEntry(Long blogEntryId);

//    Iterable<Comment> findCommentsByBlog_entry_id(Long blog_entry_id);
}
