package com.blogger.blogcast.service;

import com.blogger.blogcast.model.Blog;
import com.blogger.blogcast.model.BlogUser;
import com.blogger.blogcast.repository.BlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
//import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@Service
public class BlogService {
    private BlogRepository blogRepository;

//    @Autowired
//    private AuthService authService;

    @Autowired
    public BlogService(BlogRepository blogRepository){
        this.blogRepository = blogRepository;
    }

    public ResponseEntity<Blog> createBlog(Blog blog) {
//        User username = authService.getCurrentUser().orElseThrow(() ->
//                new IllegalArgumentException("No User Logged In"));
        blog = blogRepository.save(blog);
        URI newBlogURI = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(blog.getId()).toUri();
        HttpHeaders newHeader = new HttpHeaders();
        newHeader.setLocation(newBlogURI);
        return new ResponseEntity<>(newHeader, HttpStatus.CREATED);
    }

    public ResponseEntity<Iterable<Blog>> getAllBlogs() {
        Iterable<Blog> allBlogs = blogRepository.findAll();
        return new ResponseEntity<>(allBlogs, HttpStatus.OK);
    }

    public ResponseEntity<Blog> getBlogById(Long blogId) {
        Blog blog = blogRepository.findById(blogId).get();
        return new ResponseEntity<>(blog, HttpStatus.OK);
    }

    public ResponseEntity<Blog> updateBlog(Long blogId, Blog blog) {
        Blog original = blogRepository.findById(blogId).get();
        original.setTitle(blog.getTitle());
        original.setDescription(blog.getDescription());
        original.setOwnerId(blog.getOwnerId());
        original.setOwnerName(blog.getOwnerName());
        blogRepository.save(original);
        return new ResponseEntity<>(original, HttpStatus.OK);
    }

    public ResponseEntity<?> deleteBlog(Long blogId) {
        blogRepository.deleteById(blogId);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
