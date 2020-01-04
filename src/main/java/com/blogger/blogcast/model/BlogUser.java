package com.blogger.blogcast.model;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.List;
import java.util.Set;

@Entity
@Table
public class BlogUser {

    @Id
    @Column(name = "user_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false, unique = true)
    @Size(min=2, max=30, message = "Username size should be in the range [2...30]")
    private String username;

    @Column
    @Size(min=2, max=30, message = "Username size should be in the range [2...30]")
    private String password;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn
    private List<Blog> running;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn
    private List<Blog> following;

    //Brandon security
    @Column(name = "active")
    private int active;

    @OneToMany
    @JoinTable(name = "user_ role", joinColumns = @JoinColumn(name = "user_id" ))
    private Set<Role> roles;


    public BlogUser() { }

    public BlogUser(BlogUser blogUser){
        this.active = blogUser.getActive();
        this.username = blogUser.getUsername();
        this.password = blogUser.getPassword();
        this.id = blogUser.getId();
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    public int getActive() {
        return active;
    }

    public void setActive(int active) {
        this.active = active;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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
