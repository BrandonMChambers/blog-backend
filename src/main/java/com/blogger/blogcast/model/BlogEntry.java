package com.blogger.blogcast.model;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.time.Instant;
import java.util.Date;

@Entity
@Table(name = "ENTRY")
public class BlogEntry {

    @Id
    @Column(name = "ENTRY_ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotEmpty
    @Column//(name = "ENTRY_TITLE")
    private String title;

    @NotEmpty
    @Column//(name = "ENTRY_BODY")
    private String body;

    @Column//(name = "CREATED_ON")
    private Instant createdOn;

    @JoinColumn(name = "USER_ID")
    private Long authorId;

    @JoinColumn(name = "USER_NAME")
    private String authorName;

    @JoinColumn(name = "BLOG_ID")
    private Long blogId;

    public BlogEntry() { }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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

    public Long getBlogId() {
        return blogId;
    }

    public void setBlogId(Long blogId) {
        this.blogId = blogId;
    }
}
