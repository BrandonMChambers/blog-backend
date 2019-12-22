package com.blogger.blogcast.service;

import com.blogger.blogcast.model.BlogUser;
import com.blogger.blogcast.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Iterable<BlogUser> findAllUsers(){
        return userRepository.findAll();
    }

    public BlogUser createUser(BlogUser blogUser){
        return userRepository.save(blogUser);
    }

    public BlogUser showUser(Long id){
        return userRepository.findById(id).get();
    }

    public BlogUser updateUser(Long id, BlogUser updateBlogUser) {
        BlogUser originalBlogUser = userRepository.findById(id).get();
        originalBlogUser.setName(updateBlogUser.getName());
        return userRepository.save(originalBlogUser);
    }

    public Boolean deleteUser(Long id){
        userRepository.deleteById(id);
        return true;
    }
}
