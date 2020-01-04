package com.blogger.blogcast.repository;

import com.blogger.blogcast.model.BlogEntry;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;

@Repository
public interface BlogEntryRepository extends CrudRepository<BlogEntry, Long> {

    Iterable<BlogEntry> getBlogEntriesByBlogId(Long blogId);

}
