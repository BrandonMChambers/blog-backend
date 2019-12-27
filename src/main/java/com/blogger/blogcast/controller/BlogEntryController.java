package com.blogger.blogcast.controller;

import com.blogger.blogcast.model.BlogEntry;
import com.blogger.blogcast.service.BlogEntryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class BlogEntryController {

    BlogEntryService blogEntryServices;

    @Autowired
    public BlogEntryController(BlogEntryService blogEntryServices) {
        this.blogEntryServices = blogEntryServices;
    }

    @PostMapping("/blogEntry")
    public ResponseEntity<BlogEntry> create (@RequestBody BlogEntry blogEntry){
        blogEntry = blogEntryServices.save(blogEntry);
        return new ResponseEntity<>( blogEntryServices.create(blogEntry), HttpStatus.CREATED);
    }

    @GetMapping("/blogEntry") public ResponseEntity<Iterable<BlogEntry>> index() {
        return new ResponseEntity<>(blogEntryServices.index(), HttpStatus.OK);
    }

    @GetMapping("/blogEntry/{id}")
    public ResponseEntity<BlogEntry> show(@PathVariable Long id) {
        return new ResponseEntity<>(blogEntryServices.show(id), HttpStatus.OK);
    }

    @PutMapping("/blogEntry/{id}")
    public ResponseEntity<BlogEntry> update(@PathVariable Long id, @RequestBody BlogEntry blogEntry) {
        return new ResponseEntity<>(blogEntryServices.update(id, blogEntry), HttpStatus.OK);
    }

    @DeleteMapping("/blogEntry/{id}")
    public ResponseEntity<Boolean> destroy(@PathVariable Long id) {
        return new ResponseEntity<>(blogEntryServices.delete(id), HttpStatus.OK);
    }

}
