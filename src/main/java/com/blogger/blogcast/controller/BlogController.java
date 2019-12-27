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
@RestController
public class BlogController {

    private BlogService blogService;

    @Autowired
    public BlogController(BlogService blogService) {
        this.blogService = blogService;
    }

    @PostMapping(value = "/blog")
    public ResponseEntity<Blog> createBlog(@RequestBody Blog blog) {
        blog = blogService.create(blog);
        URI newBlogURI = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(blog.getId()).toUri();
        HttpHeaders newHeader = new HttpHeaders();
        newHeader.setLocation(newBlogURI);
        return new ResponseEntity<>(newHeader, HttpStatus.CREATED);
    }

    @GetMapping(value = "/blog")
    public ResponseEntity<Iterable<Blog>> getAllBlogs() {
        Iterable<Blog> allBlogs = blogService.findAll();
        return new ResponseEntity<>(allBlogs, HttpStatus.OK);
    }

    @GetMapping(value = "/blog/{blogId}")
    public ResponseEntity<Blog> getBlogById(@PathVariable Long blogId) {
        Blog blog = blogService.findById(blogId);
        return new ResponseEntity<>(blog, HttpStatus.OK);
    }

    @PutMapping(value = "/blog/{blogId}")
    public ResponseEntity<Blog> updateBlog(@PathVariable Long blogId, @RequestBody Blog blog) {
        Blog updated = blogService.update(blogId, blog);
        return new ResponseEntity<>(updated, HttpStatus.OK);
    }

    @DeleteMapping(value = "/blog/{blogId}")
    public ResponseEntity<?> deleteBlog(@PathVariable Long blogId) {
        blogService.delete(blogId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
