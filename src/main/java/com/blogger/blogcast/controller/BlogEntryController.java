package com.blogger.blogcast.controller;

import com.blogger.blogcast.model.Blog;
import com.blogger.blogcast.model.BlogEntry;
import com.blogger.blogcast.service.BlogEntryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*")
@RestController
public class BlogEntryController {

    private BlogEntryService blogEntryServices;

    @Autowired
    public BlogEntryController(BlogEntryService blogEntryServices) {
        this.blogEntryServices = blogEntryServices;
    }

    @PostMapping(value = "/blogEntry")
    public ResponseEntity<BlogEntry> create(@RequestBody BlogEntry blogEntry){
        return blogEntryServices.createBlogEntry(blogEntry);
    }

    @GetMapping(value = "/blogEntry")
    public ResponseEntity<Iterable<BlogEntry>> index() {
        return blogEntryServices.index();
    }

    @GetMapping(value = "/blogEntry/{id}")
    public ResponseEntity<BlogEntry> show(@PathVariable Long id) {
        return blogEntryServices.show(id);
    }

    @GetMapping(value = "/blogEntry/blog/{blogId}")
    public ResponseEntity<Iterable<BlogEntry>> getBlogEntriesByBlogId(@PathVariable Long blogId) { return blogEntryServices.getBlogEntriesByBlogId(blogId);}

    @PutMapping(value = "/blogEntry/{id}")
    public ResponseEntity<BlogEntry> update(@PathVariable Long id, @RequestBody BlogEntry blogEntry) { return blogEntryServices.update(id, blogEntry); }

    @DeleteMapping(value = "/blogEntry/{id}")
    public ResponseEntity<Boolean> destroy(@PathVariable Long id) {
        return blogEntryServices.deleteBlogEntry(id);
    }

    @GetMapping(value = "/user/{userId}/posthistory")
    public ResponseEntity<Iterable<BlogEntry>> getBlogEntriesByAuthorId(@PathVariable Long authorId) { return blogEntryServices.getBlogEntriesByAuthorId(authorId); }

    @GetMapping(value = "/user/{userId}/timeline")
    public ResponseEntity<Iterable<BlogEntry>> getBlogEntriesByUserFollowing(@PathVariable Long userId) { return blogEntryServices.getBlogEntriesByUserFollowing(userId); }


}
