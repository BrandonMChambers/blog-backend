package com.blogger.blogcast.repository;

import com.blogger.blogcast.model.BlogEntry;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.awt.*;
import java.util.ArrayList;

public interface BlogEntryRepository extends CrudRepository<BlogEntry, Long> {

    ArrayList<BlogEntry> getBlogEntriesByBlogId(Long blogId);

    ArrayList<BlogEntry> getBlogEntriesByAuthorId(Long blogId);

}
