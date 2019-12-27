package com.blogger.blogcast.model;

import javax.persistence.*;
import java.time.Instant;

@Entity
@Table
public class Blog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String blogTitle;

    @Column
    private Instant createdOn;

    public Blog() {}
    public Blog(String blogTitle, Instant createdOn){
        this.blogTitle = blogTitle;
        this.createdOn = createdOn;
    }

    public Long getId() { return id; }

    public void setId(Long id) { this.id = id; }

    public String getBlogTitle() { return blogTitle; }

    public void setBlogTitle(String blogTitle) { this.blogTitle = blogTitle; }

    public Instant getCreatedOn() { return createdOn; }

    public void setCreatedOn(Instant createdOn) { this.createdOn = createdOn; }
}
