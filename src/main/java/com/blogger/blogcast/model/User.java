package com.blogger.blogcast.model;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@Table
public class User {

    @Id
    @Column(name = "USER_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "USER_NAME")
    @Size(min=2, max=30, message = "Username size should be in the range [2...30]")
    private String username;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn
    private List<Long> running; //Ids of Blogs

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn
    private List<Long> following; //Ids of Blogs

    public User() { }

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

    public List<Long> getRunning() {
        return running;
    }

    public void setRunning(List<Long> running) {
        this.running = running;
    }

    public List<Long> getFollowing() {
        return following;
    }

    public void setFollowing(List<Long> following) {
        this.following = following;
    }

    @Override
    public String toString() {
        return "User{" + "id=" + id + ", username='" + username + ", running='" + running + ", following='" + following +
                '}';
    }


}
