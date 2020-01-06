package com.blogger.blogcast.model;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table
public class BlogUser {

    @Id
    @Column(name = "USER_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "USER_NAME")
//    @Size(min=2, max=30, message = "Username size should be in the range [2...30]")
    private String username;

    @Column(name = "PASSWORD")
//    @Size(min=2, max=30, message = "Username size should be in the range [2...30]")
    private String password;

    @Column(name = "EMAIL")
//    @Size(min=10, max=30, message = "Username size should be in the range [2...30]")
    private String email;
  
    private ArrayList<Long> running = new ArrayList<>(); //Ids of Blogs
  
    private ArrayList<Long> following = new ArrayList<>(); //Ids of Blogs


    public BlogUser() { }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

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

    public ArrayList<Long> getRunning() {
        return running;
    }

    public void setRunning(ArrayList<Long> running) {
        this.running = running;
    }

    public ArrayList<Long> getFollowing() {
        return following;
    }

    public void setFollowing(ArrayList<Long> following) {
        this.following = following;
    }

    @Override
    public String toString() {
        return "User{" + "id=" + id + ", username='" + username + ", running='" + running + ", following='" + following +
                '}';
    }


}
