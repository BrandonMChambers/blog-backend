package com.blogger.blogcast.controller;

import com.blogger.blogcast.model.BlogEntry;
import com.blogger.blogcast.service.BlogEntryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @PutMapping(value = "/blogEntry/{id}")
    public ResponseEntity<BlogEntry> update(@PathVariable Long id, @RequestBody BlogEntry blogEntry) {
        return blogEntryServices.update(id, blogEntry);
    }

    @DeleteMapping(value = "/blogEntry/{id}")
    public ResponseEntity<Boolean> destroy(@PathVariable Long id) {
        return blogEntryServices.deleteBlogEntry(id);
    }

}
