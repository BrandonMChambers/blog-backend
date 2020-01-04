package com.blogger.blogcast.controller;

import com.blogger.blogcast.model.Blog;
import com.blogger.blogcast.model.BlogUser;
import com.blogger.blogcast.security.AuthenticationRequest;
import com.blogger.blogcast.security.AuthenticationResponse;
import com.blogger.blogcast.service.BlogUserService;
import com.blogger.blogcast.service.CustomUserDetailsService;
import com.blogger.blogcast.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {


//    @Autowired
//    private AuthenticationManager authenticationManager;

//    @Autowired
//    private CustomUserDetailsService customUserDetailsService;

//    @Autowired
//    private JwtUtil jwtUtil;

    private BlogUserService blogUserService;

    @Autowired
    public UserController(BlogUserService blogUserService) {
        this.blogUserService = blogUserService;
    }

    @PostMapping(value = "/user")
    public ResponseEntity<BlogUser> createUser(@RequestBody BlogUser blogUser) {
       return blogUserService.createUser(blogUser);
    }

    @GetMapping(value = "/user")
    public ResponseEntity<Iterable<BlogUser>> getAllUsers() {
        return blogUserService.getAllUsers();
    }

    @GetMapping(value = "/user/{userId}")
    public ResponseEntity<BlogUser> getUserById(@PathVariable Long userId) {
        return blogUserService.getUserById(userId);
    }

    @PutMapping(value = "/user/{userId}")
    public ResponseEntity<BlogUser> updateUser(@PathVariable Long userId, @RequestBody BlogUser blogUser) {
        return blogUserService.updateUser(userId, blogUser);
    }

    @DeleteMapping(value = "/user/{userId}")
    public ResponseEntity<?> deleteUser(@PathVariable Long userId) {
        return blogUserService.deleteUser(userId);
    }

    @PutMapping(value = "/user/{userId}/changeusername")
    public ResponseEntity<BlogUser> changeUsername(@PathVariable Long userId, @RequestBody BlogUser blogUser) {
        return blogUserService.changeUsername(userId, blogUser);
    }

    @GetMapping(value = "/user/{userId}/running")
    public ResponseEntity<Iterable<Blog>> getAllRunning(@PathVariable Long userId) {
        return blogUserService.getAllRunning(userId);
    }

    @PutMapping(value ="/user/{userId}/running-add/{blogId}")
    public ResponseEntity<BlogUser> addBlogToRunning(@PathVariable Long userId, @PathVariable Long blogId) {
        return blogUserService.addBlogToRunning(userId, blogId);
    }

    @PutMapping(value ="/user/{userId}/running-drop/{blogId}")
    public ResponseEntity<BlogUser> removeBlogFromRunning(@PathVariable Long userId, @PathVariable Long blogId) {
        return blogUserService.removeFromRunning(userId,blogId);
    }

    @GetMapping(value = "/user/{userId}/following")
    public ResponseEntity<Iterable<Blog>> getAllFollowing(@PathVariable Long userId) {
        return blogUserService.getAllFollowing(userId);
    }

    @PutMapping(value ="/user/{userId}/following-add/{blogId}")
    public ResponseEntity<BlogUser> addBlogToFollowing(@PathVariable Long userId, @PathVariable Long blogId) {
        return blogUserService.addBlogToFollowing(userId, blogId);
    }

    @PutMapping(value ="/user/{userId}/following-drop/{blogId}")
    public ResponseEntity<BlogUser> removeBlogFromFollowing(@PathVariable Long userId, @PathVariable Long blogId) {
        return blogUserService.removeBlogFromFollowing(userId, blogId);
    }

//    @PostMapping(value = "/authenticate")
//    public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthenticationRequest authenticationRequest) throws Exception {
//        try {
//            authenticationManager.authenticate(
//                    new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(), authenticationRequest.getPassword())
//            );
//        } catch (BadCredentialsException e) {
//            throw new Exception("Incorrect username or password", e);
//        }
//        final UserDetails userDetails = customUserDetailsService
//                .loadUserByUsername(authenticationRequest.getUsername());
//
//        final String jwt = jwtUtil.generateToken(userDetails);
//
//        return ResponseEntity.ok(new AuthenticationResponse(jwt));
//    }
}