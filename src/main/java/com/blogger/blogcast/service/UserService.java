package com.blogger.blogcast.service;

import com.blogger.blogcast.model.Blog;
import com.blogger.blogcast.model.BlogUser;
import com.blogger.blogcast.repository.BlogRepository;
import com.blogger.blogcast.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    private UserRepository userRepository;
    private BlogRepository blogRepository;

    @Autowired
    public UserService(UserRepository userRepository, BlogRepository blogRepository) {
        this.userRepository = userRepository;
        this.blogRepository = blogRepository;
    }

    public ResponseEntity<BlogUser> createUser(BlogUser blogUser) {
        blogUser = userRepository.save(blogUser);
        URI newBlogURI = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(blogUser.getId()).toUri();
        HttpHeaders newHeader = new HttpHeaders();
        newHeader.setLocation(newBlogURI);
        return new ResponseEntity<>(newHeader, HttpStatus.CREATED);
    }

    public ResponseEntity<Iterable<BlogUser>> getAllUsers() {
        Iterable<BlogUser> allUsers = userRepository.findAll();
        return new ResponseEntity<>(allUsers, HttpStatus.OK);
    }

    public ResponseEntity<BlogUser> getUserById(Long userId) {
        BlogUser blogUser = userRepository.findById(userId).get();
        return new ResponseEntity<>(blogUser, HttpStatus.OK);
    }

    public ResponseEntity<BlogUser> updateUser(Long userId, BlogUser blogUser) {
        BlogUser original = userRepository.findById(userId).get();
        original.setUsername(blogUser.getUsername());
        original.setRunning(blogUser.getRunning());
        original.setFollowing(blogUser.getFollowing());
        userRepository.save(original);
        return new ResponseEntity<>(original, HttpStatus.OK);
    }


    public ResponseEntity<?> deleteUser(Long userId) {
        userRepository.deleteById(userId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    public ResponseEntity<BlogUser> changeUsername(Long userId, BlogUser blogUser) {
        BlogUser original = userRepository.findById(userId).get();
        original.setUsername(blogUser.getUsername());
        userRepository.save(original);
        return new ResponseEntity<>(original, HttpStatus.OK);
    }

    public ResponseEntity<Iterable<Long>> getAllRunning(Long userId) {
        BlogUser user = userRepository.findById(userId).get();
        user.getRunning();
        Iterable<Long> running = user.getRunning();
        return new ResponseEntity<>(running, HttpStatus.OK);
    }

    public ResponseEntity<BlogUser> addBlogToRunning(Long userId, Long blogId) {
        BlogUser user = userRepository.findById(userId).get();
        ArrayList<Long> running = user.getRunning();
        running.add(blogId);
        user.setRunning(running);
        userRepository.save(user);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    public ResponseEntity<BlogUser> removeFromRunning(Long userId, Long blogId) {
        BlogUser user = userRepository.findById(userId).get();
        ArrayList<Long> running = user.getRunning();
        running.remove(blogId);
        user.setRunning(running);
        userRepository.save(user);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    public ResponseEntity<Iterable<Long>> getAllFollowing(Long userId) {
        BlogUser user = userRepository.findById(userId).get();
        Iterable<Long> following = user.getFollowing();
        return new ResponseEntity<>(following, HttpStatus.OK);
    }

    public ResponseEntity<BlogUser> addBlogToFollowing(Long userId, Long blogId) {
        BlogUser user = userRepository.findById(userId).get();
        ArrayList<Long> following = user.getFollowing();
        following.add(blogId);
        user.setFollowing(following);
        userRepository.save(user);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    public ResponseEntity<BlogUser> removeBlogFromFollowing(Long userId, Long blogId) {
        BlogUser user = userRepository.findById(userId).get();
        ArrayList<Long> following = user.getFollowing();
        following.remove(blogId);
        user.setFollowing(following);
        userRepository.save(user);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

}