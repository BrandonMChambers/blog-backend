package com.blogger.blogcast.model;
import javax.persistence.*;
import javax.validation.constraints.Size;
import java.time.Instant;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table
public class Blog {

    @Id
    @Column(name = "BLOG_ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "title")
    @Size(min=1, max=255)
    private String title;

    @Column(name = "description")
    @Size(min=1, max=2000)
    private String description;

    @Column(name = "created_on")
    private Instant createdOn;

    @JoinColumn(name = "USER_ID")
    private Long ownerId;

    @JoinColumn(name = "USER_NAME")
    private String ownerName;

    public Blog() { }

    public Long getId() { return id; }

    public void setId(Long id) { this.id = id; }

    public String getTitle() { return title; }

    public void setTitle(String title) { this.title = title; }

    public String getDescription() { return description; }

    public void setDescription(String description) { this.description = description; }

    public Instant getCreatedOn() { return createdOn; }

    public void setCreatedOn(Instant createdOn) { this.createdOn = createdOn; }

    public Long getOwnerId() { return ownerId; }

    public void setOwnerId(Long ownerId) { this.ownerId = ownerId; }

    public String getOwnerName() { return ownerName; }

    public void setOwnerName(String ownerName) { this.ownerName = ownerName; }

}