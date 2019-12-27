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

@RestController
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping(value = "/user")
    public ResponseEntity<User> createUser(@RequestBody User user) {
        user = userService.create(user);
        URI newBlogURI = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(user.getId()).toUri();
        HttpHeaders newHeader = new HttpHeaders();
        newHeader.setLocation(newBlogURI);
        return new ResponseEntity<>(newHeader, HttpStatus.CREATED);
    }

    @GetMapping(value = "/user")
    public ResponseEntity<Iterable<User>> getAllUsers() {
        Iterable<User> allUsers = userService.findAll();
        return new ResponseEntity<>(allUsers, HttpStatus.OK);
    }

    @GetMapping(value = "/user/{userId}")
    public ResponseEntity<User> getUserById(@PathVariable Long userId) {
        User user = userService.findById(userId);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @PutMapping(value = "/user/{userId}")
    public ResponseEntity<User> updateUser(@PathVariable Long userId, @RequestBody User user) {
        User updated = userService.update(userId, user);
        return new ResponseEntity<>(updated, HttpStatus.OK);
    }

    @DeleteMapping(value = "/user/{userId}")
    public ResponseEntity<?> deleteUser(@PathVariable Long userId) {
        userService.delete(userId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping(value = "/user/{userId}/changeusername")
    public ResponseEntity<User> changeUsername(@PathVariable Long userId, @RequestBody User user) {
        User updated = userService.changeUsername(userId, user);
        return new ResponseEntity<>(updated, HttpStatus.OK);
    }

    @GetMapping(value = "/user/{userId}/running")
    public ResponseEntity<Iterable<Blog>> getAllRunning(@PathVariable Long userId) {
        Iterable<Blog> running = userService.getRunning(userId);
        return new ResponseEntity<>(running, HttpStatus.OK);
    }

    @PutMapping(value ="/user/{userId}/running-add/{blogId}")
    public ResponseEntity<User> addBlogToRunning(@PathVariable Long userId, @PathVariable Long blogId) {
        User user = userService.addToRunning(userId, blogId);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @PutMapping(value ="/user/{userId}/running-drop/{blogId}")
    public ResponseEntity<User> removeBlogFromRunning(@PathVariable Long userId, @PathVariable Long blogId) {
        User user = userService.removeFromRunning(userId, blogId);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @GetMapping(value = "/user/{userId}/following")
    public ResponseEntity<Iterable<Blog>> getAllFollowing(@PathVariable Long userId) {
        Iterable<Blog> following = userService.getFollowing(userId);
        return new ResponseEntity<>(following, HttpStatus.OK);
    }

    @PutMapping(value ="/user/{userId}/following-add/{blogId}")
    public ResponseEntity<User> addBlogToFollowing(@PathVariable Long userId, @PathVariable Long blogId) {
        User user = userService.addToFollowing(userId, blogId);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @PutMapping(value ="/user/{userId}/following-drop/{blogId}")
    public ResponseEntity<User> removeBlogFromFollowing(@PathVariable Long userId, @PathVariable Long blogId) {
        User user = userService.removeFromFollowing(userId, blogId);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }
}