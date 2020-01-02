package com.blogger.blogcast.model;

import com.blogger.blogcast.repository.BlogRepository;

import javax.persistence.*;
import java.time.Instant;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table
public class Blog {

    @Id
    @Column(name = "BLOG_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String title;

    @Column
    private String description;

    @Column
    private Instant createdOn;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn
    private List<BlogEntry> blogEntries;

    public Blog() { }

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Instant getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(Instant createdOn) {
        this.createdOn = createdOn;
    }

    public List<BlogEntry> getBlogEntries() { return blogEntries; }

    public void setBlogEntries(List<BlogEntry> blogEntries) { this.blogEntries = blogEntries; }
}
