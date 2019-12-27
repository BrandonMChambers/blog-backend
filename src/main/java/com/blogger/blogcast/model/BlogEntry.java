package com.blogger.blogcast.model;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.time.Instant;
import java.util.Date;

@Entity
@Table(name = "BLOGENTRY")
public class BlogEntry {

    @Id
    @Column(name = "BLOGENTRY_ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @JoinColumn(name = "USER_ID")
    private Long user_Id;

    @JoinColumn(name = "BLOG_ID")
    private Long blog_Id;

    @NotEmpty
    @Column(name = "TITLE")
    private String title;

    @NotEmpty
    @Column(name = "BLOGBODY")
    private String body;

    @Column(name = "CREATED_ON")
    private Instant createdOn;

    public BlogEntry(Long blogEntryId, Long userId, Long blogId, String title, String body, Instant createdOn) {
        this.id = blogEntryId;
        this.user_Id = userId;
        this.blog_Id = blogId;
        this.title = title;
        this.body = body;
    }

    public BlogEntry(String title, String body, Instant createdOn){
        this(null, null, null, title, body, createdOn);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUser_Id() {
        return user_Id;
    }

    public void setUser_Id(Long user_Id) {
        this.user_Id = user_Id;
    }

    public Long getBlog_Id() {
        return blog_Id;
    }

    public void setBlog_Id(Long blog_Id) {
        this.blog_Id = blog_Id;
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

}
