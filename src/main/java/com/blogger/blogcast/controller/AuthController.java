package com.blogger.blogcast.controller;

import com.blogger.blogcast.security.RegisterRequest;
import com.blogger.blogcast.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping("/signup")
    public ResponseEntity signup(@RequestBody RegisterRequest registerRequest){
            authService.signup(registerRequest);
            return new ResponseEntity(HttpStatus.OK);
    }
}
