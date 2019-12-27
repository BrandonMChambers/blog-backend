package com.blogger.blogcast.model;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "TIMELINE")
public class Timeline {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "TITLE")
    private String title;


    @Column(name = "TIMESTAMP")
    private Date timeStamp;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn
    private Set<BlogEntry> allBlogEntries = new HashSet<>();

    public Timeline(String title, Date timeStamp, Set<BlogEntry> allBlogEntries){
        this(null, title, timeStamp, allBlogEntries);
    }

    public Timeline() {
    }

    public Timeline(Long id, String title, Date timeStamp, Set<BlogEntry> allBlogEntries){
        this.id = id;
        this.title = title;
        this.timeStamp = timeStamp;
        this.allBlogEntries = allBlogEntries;
    }

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

    public Date getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(Date timeStamp) {
        this.timeStamp = timeStamp;
    }

    @Override
    public String toString(){

        return "Timeline{" + "id=" + id + ", title=" + title +
                ", timestamp=" + timeStamp + ", allBlogEntries=" + allBlogEntries + "}";
    }
}
