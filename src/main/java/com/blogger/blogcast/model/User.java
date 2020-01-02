package com.blogger.blogcast.model;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@Table
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    @Size(min=2, max=30, message = "Username size should be in the range [2...30]")
    private String username;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn
    private List<Blog> running;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn
    private List<Blog> following;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public List<Blog> getRunning() {
        return running;
    }

    public void setRunning(List<Blog> running) {
        this.running = running;
    }

    public List<Blog> getFollowing() {
        return following;
    }

    public void setFollowing(List<Blog> following) {
        this.following = following;
    }

    @Override
    public String toString() {
        return "User{" + "id=" + id + ", username='" + username + ", running='" + running + ", following='" + following +
                '}';
    }


}
