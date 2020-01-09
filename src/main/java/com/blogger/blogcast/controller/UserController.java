package com.blogger.blogcast.controller;

import com.blogger.blogcast.model.Blog;
import com.blogger.blogcast.model.BlogUser;
import com.blogger.blogcast.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*")
@RestController
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping(value = "/user")
    public ResponseEntity<BlogUser> createUser(@RequestBody BlogUser blogUser) {
       return userService.createUser(blogUser);
    }

    @GetMapping(value = "/user")
    public ResponseEntity<Iterable<BlogUser>> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping(value = "/user/{userId}")
    public ResponseEntity<BlogUser> getUserById(@PathVariable Long userId) {
        return userService.getUserById(userId);
    }

    @PutMapping(value = "/user/{userId}")
    public ResponseEntity<BlogUser> updateUser(@PathVariable Long userId, @RequestBody BlogUser blogUser) {
        return userService.updateUser(userId, blogUser);
    }

    @DeleteMapping(value = "/user/{userId}")
    public ResponseEntity<?> deleteUser(@PathVariable Long userId) {
        return userService.deleteUser(userId);
    }

    @PutMapping(value = "/user/{userId}/changeusername")
    public ResponseEntity<BlogUser> changeUsername(@PathVariable Long userId, @RequestBody BlogUser blogUser) {
        return userService.changeUsername(userId, blogUser);
    }

    @GetMapping(value = "/user/{userId}/running")
    public ResponseEntity<Iterable<Long>> getAllRunning(@PathVariable Long userId) {
        return userService.getAllRunning(userId);
    }

    @PutMapping(value ="/user/{userId}/running-add/{blogId}")
    public ResponseEntity<BlogUser> addBlogToRunning(@PathVariable Long userId, @PathVariable Long blogId) {
        return userService.addBlogToRunning(userId, blogId);
    }

    @PutMapping(value ="/user/{userId}/running-drop/{blogId}")
    public ResponseEntity<BlogUser> removeBlogFromRunning(@PathVariable Long userId, @PathVariable Long blogId) {
        return userService.removeFromRunning(userId,blogId);
    }

    @GetMapping(value = "/user/{userId}/following")
    public ResponseEntity<Iterable<Long>> getAllFollowing(@PathVariable Long userId) {
        return userService.getAllFollowing(userId);
    }

    @PutMapping(value ="/user/{userId}/following-add/{blogId}")
    public ResponseEntity<BlogUser> addBlogToFollowing(@PathVariable Long userId, @PathVariable Long blogId) {
        return userService.addBlogToFollowing(userId, blogId);
    }

    @PutMapping(value ="/user/{userId}/following-drop/{blogId}")
    public ResponseEntity<BlogUser> removeBlogFromFollowing(@PathVariable Long userId, @PathVariable Long blogId) {
        return userService.removeBlogFromFollowing(userId, blogId);
    }
}