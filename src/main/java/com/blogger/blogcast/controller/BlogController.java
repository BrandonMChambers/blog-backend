package com.blogger.blogcast.controller;

import com.blogger.blogcast.model.Blog;
import com.blogger.blogcast.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class BlogController {

    private BlogService blogService;

    @Autowired
    public BlogController(BlogService blogService) {
        this.blogService = blogService;
    }

    @PostMapping(value = "/blog")
    public ResponseEntity<Blog> createBlog(@RequestBody Blog blog) {
        return blogService.createBlog(blog);
    }

    @GetMapping(value = "/blog")
    public ResponseEntity<Iterable<Blog>> getAllBlogs() {
        return blogService.getAllBlogs();
    }

    @GetMapping(value = "/blog/{blogId}")
    public ResponseEntity<Blog> getBlogById(@PathVariable Long blogId) {
        return blogService.getBlogById(blogId);
    }


    @PutMapping(value = "/blog/{blogId}")
    public ResponseEntity<Blog> updateBlog(@PathVariable Long blogId, @RequestBody Blog blog) {
        return blogService.updateBlog(blogId, blog);
    }

    @DeleteMapping(value = "/blog/{blogId}")
    public ResponseEntity<?> deleteBlog(@PathVariable Long blogId) {
        return blogService.deleteBlog(blogId);
    }

}
