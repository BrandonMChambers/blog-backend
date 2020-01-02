package com.blogger.blogcast.repository;

import com.blogger.blogcast.model.BlogEntry;
import org.springframework.data.repository.CrudRepository;

public interface BlogEntryRepository extends CrudRepository<BlogEntry, Long> {

    Iterable<BlogEntry> getBlogEntriesByBlogId(Long blogId);

}
