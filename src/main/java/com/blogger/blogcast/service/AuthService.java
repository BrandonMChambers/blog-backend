package com.blogger.blogcast.service;

import com.blogger.blogcast.model.BlogUser;
import com.blogger.blogcast.repository.UserRepository;
import com.blogger.blogcast.security.JwtProvider;
import com.blogger.blogcast.security.LoginRequest;
import com.blogger.blogcast.security.RegisterRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtProvider jwtProvider;

    public void signup(RegisterRequest registerRequest){
        BlogUser blogUser = new BlogUser();
        blogUser.setUsername(registerRequest.getUsername());
        blogUser.setEmail(registerRequest.getEmail());
        blogUser.setPassword(encodePassword(registerRequest.getPassword()));
        userRepository.save(blogUser);
    }

    private String encodePassword(String password){
        return passwordEncoder.encode(password);
    }

    public String login(LoginRequest loginRequest){
       Authentication authenticate = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginRequest.getUsername(),
                loginRequest.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authenticate);
        return jwtProvider.generateToken(authenticate);
    }

    public Optional<org.springframework.security.core.userdetails.User> getCurrentUser(){
        org.springframework.security.core.userdetails.User principal = (org.springframework.security.core.userdetails.User) SecurityContextHolder
                .getContext().getAuthentication().getPrincipal();
        return Optional.of(principal);
    }
}
