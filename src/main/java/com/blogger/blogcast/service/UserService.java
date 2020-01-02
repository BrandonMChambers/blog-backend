package com.blogger.blogcast.service;

import com.blogger.blogcast.model.Blog;
import com.blogger.blogcast.model.User;
import com.blogger.blogcast.repository.BlogRepository;
import com.blogger.blogcast.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
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

    public ResponseEntity<User> createUser(User user) {
        user = userRepository.save(user);
        URI newBlogURI = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(user.getId()).toUri();
        HttpHeaders newHeader = new HttpHeaders();
        newHeader.setLocation(newBlogURI);
        return new ResponseEntity<>(newHeader, HttpStatus.CREATED);
    }

    public ResponseEntity<Iterable<User>> getAllUsers() {
        Iterable<User> allUsers = userRepository.findAll();
        return new ResponseEntity<>(allUsers, HttpStatus.OK);
    }

    public ResponseEntity<User> getUserById(Long userId) {
        User user = userRepository.findById(userId).get();
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    public ResponseEntity<User> updateUser(Long userId, User user) {
        User original = userRepository.findById(userId).get();
        original.setUsername(user.getUsername());
        original.setRunning(user.getRunning());
        original.setFollowing(user.getFollowing());
        userRepository.save(original);
        return new ResponseEntity<>(original, HttpStatus.OK);
    }


    public ResponseEntity<?> deleteUser(Long userId) {
        userRepository.deleteById(userId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    public ResponseEntity<User> changeUsername(Long userId, User user) {
        User original = userRepository.findById(userId).get();
        original.setUsername(user.getUsername());
        userRepository.save(original);
        return new ResponseEntity<>(original, HttpStatus.OK);
    }

    public ResponseEntity<Iterable<Long>> getAllRunning(Long userId) {
        User user = userRepository.findById(userId).get();
        user.getRunning();
        Iterable<Long> running = user.getRunning();
        return new ResponseEntity<>(running, HttpStatus.OK);
    }

    public ResponseEntity<User> addBlogToRunning(Long userId, Long blogId) {
        User user = userRepository.findById(userId).get();
        List<Long> running = user.getRunning();
        running.add(blogId);
        user.setRunning(running);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    public ResponseEntity<User> removeFromRunning(Long userId, Long blogId) {
        User user = userRepository.findById(userId).get();
        List<Long> running = user.getFollowing();
        running.remove(blogId);
        user.setFollowing(running);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    public ResponseEntity<Iterable<Long>> getAllFollowing(Long userId) {
        User user = userRepository.findById(userId).get();
        Iterable<Long> following = user.getFollowing();
        return new ResponseEntity<>(following, HttpStatus.OK);
    }

    public ResponseEntity<User> addBlogToFollowing(Long userId, Long blogId) {
        User user = userRepository.findById(userId).get();
        List<Long> following = user.getFollowing();
        following.add(blogId);
        user.setFollowing(following);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    public ResponseEntity<User> removeBlogFromFollowing(Long userId, Long blogId) {
        User user = userRepository.findById(userId).get();
        List<Long> following = user.getFollowing();
        following.remove(blogId);
        user.setFollowing(following);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }









































/*
    public User create(User user) { return userRepository.save(user); }

    public Iterable<User> findAll() {
        return userRepository.findAll();
    }

    public User findById(Long id) {
        return userRepository.findById(id).get();
    }

    public User update(Long id, User user) {
        User original = userRepository.findById(id).get();
        original.setUsername(user.getUsername());
        original.setRunning(user.getRunning());
        original.setFollowing(user.getFollowing());
        return userRepository.save(original);
    }

    public Boolean delete(Long id) {
        User blog = userRepository.findById(id).get();
        userRepository.delete(blog);
        return true;
    }

    public User changeUsername(Long id, User user) {
        User original = findById(id);
        original.setUsername(user.getUsername());
        return userRepository.save(original);
    }

    public List<Blog> getRunning(Long userId) {
        User user = findById(userId);
        return user.getRunning();
    }

    public User addToRunning(Long userId, Long blogId) {
        User user = findById(userId);
        Blog toAdd = blogService.findById(blogId);
        List<Blog> running = user.getRunning();
        running.add(toAdd);
        user.setRunning(running);
        return update(userId, user);
    }

    public User removeFromRunning(Long userId, Long blogId) {
        User user = findById(userId);
        Blog toDrop = blogService.findById(blogId);
        List<Blog> running = user.getRunning();
        running.remove(toDrop);
        user.setRunning(running);
        return update(userId, user);
    }

    public List<Blog> getFollowing(Long userId) {
        User user = findById(userId);
        return user.getFollowing();
    }

    public User addToFollowing(Long userId, Long blogId) {
        User user = findById(userId);
        Blog toAdd = blogService.findById(blogId);
        List<Blog> following = user.getFollowing();
        following.add(toAdd);
        user.setFollowing(following);
        return update(userId, user);
    }

    public User removeFromFollowing(Long userId, Long blogId) {
        User user = findById(userId);
        Blog toDrop = blogService.findById(blogId);
        List<Blog> following = user.getFollowing();
        following.remove(toDrop);
        user.setFollowing(following);
        return update(userId, user);
    }

 */

}
