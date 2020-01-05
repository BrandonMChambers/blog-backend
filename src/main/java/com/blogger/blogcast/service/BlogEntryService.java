package com.blogger.blogcast.service;

import com.blogger.blogcast.model.Blog;
import com.blogger.blogcast.model.BlogEntry;
import com.blogger.blogcast.model.User;
import com.blogger.blogcast.repository.BlogEntryRepository;
import com.blogger.blogcast.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

@Service
public class BlogEntryService {
    private BlogEntryRepository blogEntryRepository;
    private UserRepository userRepository;

    @Autowired
    public BlogEntryService(BlogEntryRepository blogEntryRepository, UserRepository userRepository) {
        this.blogEntryRepository = blogEntryRepository;
        this.userRepository = userRepository;
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

    public ResponseEntity<Iterable<BlogEntry>> getBlogEntriesByAuthorId(Long authorId) {
        List<BlogEntry> postHistory = blogEntryRepository.getBlogEntriesByAuthorId(authorId);
        Collections.sort(postHistory);
        return new ResponseEntity<>(postHistory, HttpStatus.OK);
    }

    public ResponseEntity<Iterable<BlogEntry>> getBlogEntriesByUserFollowing(Long userId) {
        List<BlogEntry> timeline = new ArrayList();
        Iterable<Long> followingIds = userRepository.findById(userId).get().getRunning();
        for(Long blogId : followingIds) { timeline.addAll(blogEntryRepository.getBlogEntriesByBlogId(blogId)); }
        Collections.sort(timeline);
        return new ResponseEntity<>(timeline, HttpStatus.OK);
    }
}
