package com.blogger.blogcast.service;

import com.blogger.blogcast.security.AuthenticationRequest;
import com.blogger.blogcast.model.BlogUser;
import com.blogger.blogcast.repository.BlogUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    @Autowired
    private BlogUserRepository blogUserRepository;

    public void signUp(AuthenticationRequest authenticationRequest){
        BlogUser blogUser = new BlogUser();
        blogUser.setUsername(authenticationRequest.getUsername());
        blogUser.setPassword(authenticationRequest.getPassword());
        blogUserRepository.save(blogUser);
    }
}
