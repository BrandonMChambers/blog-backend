package com.blogger.blogcast.service;

import com.blogger.blogcast.model.Blog;
import com.blogger.blogcast.model.User;
import com.blogger.blogcast.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    UserRepository userRepository;
    BlogService blogService;

    @Autowired
    public UserService(UserRepository userRepository, BlogService blogService) {
        this.userRepository = userRepository;
        this.blogService = blogService;
    }

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

}
