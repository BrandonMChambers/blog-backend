package com.blogger.blogcast.service;

import com.blogger.blogcast.model.Blog;
import com.blogger.blogcast.model.BlogEntry;
import com.blogger.blogcast.repository.BlogEntryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

@Service
public class BlogEntryService {
    private BlogEntryRepository blogEntryRepository;

    @Autowired
    public BlogEntryService(BlogEntryRepository blogEntryRepository) {
        this.blogEntryRepository = blogEntryRepository;
    }

    public ResponseEntity<BlogEntry> createBlogEntry(@RequestBody BlogEntry blogEntry){
        blogEntry = blogEntryRepository.save(blogEntry);
        return new ResponseEntity<>(blogEntry, HttpStatus.CREATED);
    }

    public ResponseEntity<Iterable<BlogEntry>> index() {
        Iterable<BlogEntry> allBlogEntries = blogEntryRepository.findAll();
        return new ResponseEntity<>(allBlogEntries, HttpStatus.OK);
    }

    public ResponseEntity<BlogEntry> show( Long id) {
        return new ResponseEntity<>(blogEntryRepository.findById(id).get(), HttpStatus.OK);
    }

    public ResponseEntity<Iterable<BlogEntry>> getBlogEntriesByBlogId(Long blogId) {
        Iterable<BlogEntry> allBlogEntries = blogEntryRepository.getBlogEntriesByBlogId(blogId);
        return new ResponseEntity<>(allBlogEntries, HttpStatus.OK);
    }


    public ResponseEntity<BlogEntry> update(Long id, BlogEntry blogEntry) {
        BlogEntry original = blogEntryRepository.findById(id).get();
        original.setTitle(blogEntry.getTitle());
        original.setBody(blogEntry.getBody());
        blogEntryRepository.save(original);
        return new ResponseEntity<>(original, HttpStatus.OK);
    }

    public ResponseEntity<Boolean> deleteBlogEntry(Long id) {
        blogEntryRepository.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    public ResponseEntity<Iterable<BlogEntry>> getEntriesForBlog(Long blogId) {
        Iterable<BlogEntry> entries = blogEntryRepository.getBlogEntriesByBlogId(blogId);
        return new ResponseEntity<>(entries, HttpStatus.OK);
    }


}
