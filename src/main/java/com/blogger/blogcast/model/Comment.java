package com.blogger.blogcast.model;
import javax.persistence.*;
import java.time.Instant;

/**
 * I might have been overly explicit in my table and column annotations.
 * if they need to be changed or removed, that's fine
 */

/**
 * Comment Postable
 *      body
 *      userId
 *      timestamp
 *      blogEntryId
 *      edited?
 *          editedTimestamp
 *
 * Comment Readable
 *      commentId
 *      body
 *      username
 *      timestamp
 *      blogEntryId
 *      edited?
 *          editedTimestamp
 */

@Entity
@Table//(name = "comment")
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
   // @Column//(name = "COMMENT_ID")
    private Long id;

    @Column//(name = "COMMENT_BODY")
    private String body;

    @Column
    private Instant createdOn;

    @JoinColumn//(name = "USER_ID")
    private Long authorId;

    @JoinColumn//(name = "USER_NAME")
    private String authorName;

    @JoinColumn//(name = "ENTRY_ID")
    private Long blogEntryId;

    public Comment() { }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public Instant getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(Instant createdOn) {
        this.createdOn = createdOn;
    }

    public Long getAuthorId() {
        return authorId;
    }

    public void setAuthorId(Long authorId) {
        this.authorId = authorId;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public Long getBlogEntryId() {
        return blogEntryId;
    }

    public void setBlogEntryId(Long blogEntryId) {
        this.blogEntryId = blogEntryId;
    }
}
