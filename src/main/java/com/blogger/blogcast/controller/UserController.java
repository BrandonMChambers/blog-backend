package com.blogger.blogcast.controller;

import com.blogger.blogcast.model.BlogUser;
import com.blogger.blogcast.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }
    //works
    @GetMapping("/all")
    public ResponseEntity<Iterable<BlogUser>> findAll() {
        return new ResponseEntity<>(userService.findAllUsers(), HttpStatus.OK);
    }
    //works
    @GetMapping("/user/{id}")
    public ResponseEntity<BlogUser> findById(@PathVariable Long id) {
        return new ResponseEntity<>(userService.showUser(id), HttpStatus.OK);
    }
    //works
    @PostMapping("/addUser")
    public ResponseEntity<BlogUser> addNewUser(@RequestBody BlogUser blogUser) {
        return new ResponseEntity<>(userService.createUser(blogUser), HttpStatus.CREATED);
    }
    //works
    @PutMapping("/user/{id}")
    public ResponseEntity<BlogUser> updateUser(@PathVariable Long id, @RequestBody BlogUser blogUser) {
        return new ResponseEntity<>(userService.updateUser(id, blogUser), HttpStatus.OK);
    }
    //works
    @DeleteMapping("/deleteUser/{id}")
    public ResponseEntity<Boolean> deleteUser(@PathVariable Long id) {
       return new ResponseEntity<>(userService.deleteUser(id), HttpStatus.OK);
    }

}
