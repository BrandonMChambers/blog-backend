package com.blogger.blogcast.service;

import com.blogger.blogcast.model.User;
import com.blogger.blogcast.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Iterable<User> findAllUsers(){
        return userRepository.findAll();
    }

    public User createUser(User user){
        return userRepository.save(user);
    }

    public User showUser(Long id){
        return userRepository.findById(id).get();
    }

    public User updateUser(Long id, User updateUser) {
        User originalUser = userRepository.findById(id).get();
        originalUser.setName(updateUser.getName());
        return userRepository.save(originalUser);
    }

    public Boolean deleteUser(Long id){
        userRepository.deleteById(id);
        return true;
    }
}
