package com.blogger.blogcast.controller;

import com.blogger.blogcast.model.Blog;
import com.blogger.blogcast.model.User;
import com.blogger.blogcast.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@CrossOrigin(origins = "*")
@RestController
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping(value = "/user")
    public ResponseEntity<User> createUser(@RequestBody User user) {
       return userService.createUser(user);
    }

    @GetMapping(value = "/user")
    public ResponseEntity<Iterable<User>> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping(value = "/user/{userId}")
    public ResponseEntity<User> getUserById(@PathVariable Long userId) {
        return userService.getUserById(userId);
    }

    @PutMapping(value = "/user/{userId}")
    public ResponseEntity<User> updateUser(@PathVariable Long userId, @RequestBody User user) {
        return userService.updateUser(userId, user);
    }

    @DeleteMapping(value = "/user/{userId}")
    public ResponseEntity<?> deleteUser(@PathVariable Long userId) {
        return userService.deleteUser(userId);
    }

    @PutMapping(value = "/user/{userId}/changeusername")
    public ResponseEntity<User> changeUsername(@PathVariable Long userId, @RequestBody User user) {
        return userService.changeUsername(userId, user);
    }

    @GetMapping(value = "/user/{userId}/running")
    public ResponseEntity<Iterable<Long>> getAllRunning(@PathVariable Long userId) {
        return userService.getAllRunning(userId);
    }

    @PutMapping(value ="/user/{userId}/running-add/{blogId}")
    public ResponseEntity<User> addBlogToRunning(@PathVariable Long userId, @PathVariable Long blogId) {
        return userService.addBlogToRunning(userId, blogId);
    }

    @PutMapping(value ="/user/{userId}/running-drop/{blogId}")
    public ResponseEntity<User> removeBlogFromRunning(@PathVariable Long userId, @PathVariable Long blogId) {
        return userService.removeFromRunning(userId,blogId);
    }

    @GetMapping(value = "/user/{userId}/following")
    public ResponseEntity<Iterable<Long>> getAllFollowing(@PathVariable Long userId) {
        return userService.getAllFollowing(userId);
    }

    @PutMapping(value ="/user/{userId}/following-add/{blogId}")
    public ResponseEntity<User> addBlogToFollowing(@PathVariable Long userId, @PathVariable Long blogId) {
        return userService.addBlogToFollowing(userId, blogId);
    }

    @PutMapping(value ="/user/{userId}/following-drop/{blogId}")
    public ResponseEntity<User> removeBlogFromFollowing(@PathVariable Long userId, @PathVariable Long blogId) {
        return userService.removeBlogFromFollowing(userId, blogId);
    }
}