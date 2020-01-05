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

    public ResponseEntity<Iterable<Blog>> getAllRunning(Long userId) {
        BlogUser blogUser = userRepository.findById(userId).get();
        blogUser.getRunning();
        Iterable<Blog> running = blogUser.getRunning();
        return new ResponseEntity<>(running, HttpStatus.OK);
    }

    public ResponseEntity<BlogUser> addBlogToRunning(Long userId, Long blogId) {
        BlogUser blogUser = userRepository.findById(userId).get();
        Blog toAdd = blogRepository.findById(blogId).get();
        List<Blog> running = blogUser.getRunning();
        running.add(toAdd);
        blogUser.setRunning(running);
        userRepository.save(blogUser);
        return new ResponseEntity<>(blogUser, HttpStatus.OK);
    }

    public ResponseEntity<BlogUser> removeFromRunning(Long userId, Long blogId) {
        BlogUser blogUser = userRepository.findById(userId).get();
        Blog toDrop = blogRepository.findById(blogId).get();
        List<Blog> running = blogUser.getRunning();
        running.remove(toDrop);
        blogUser.setRunning(running);
        userRepository.save(blogUser);
        return new ResponseEntity<>(blogUser, HttpStatus.OK);
    }

    public ResponseEntity<Iterable<Blog>> getAllFollowing(Long userId) {
        BlogUser blogUser = userRepository.findById(userId).get();
        Iterable<Blog> following = blogUser.getFollowing();
        return new ResponseEntity<>(following, HttpStatus.OK);
    }

    public ResponseEntity<BlogUser> addBlogToFollowing(Long userId, Long blogId) {
        BlogUser blogUser = userRepository.findById(userId).get();
        Blog toAdd = blogRepository.findById(blogId).get();
        List<Blog> following = blogUser.getFollowing();
        following.add(toAdd);
        blogUser.setFollowing(following);
        userRepository.save(blogUser);
        return new ResponseEntity<>(blogUser, HttpStatus.OK);
    }

    public ResponseEntity<BlogUser> removeBlogFromFollowing(Long userId, Long blogId) {
        BlogUser blogUser = userRepository.findById(userId).get();
        Blog toDrop = blogRepository.findById(blogId).get();
        List<Blog> following = blogUser.getFollowing();
        following.remove(toDrop);
        blogUser.setFollowing(following);
        userRepository.save(blogUser);
        return new ResponseEntity<>(blogUser, HttpStatus.OK);
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
