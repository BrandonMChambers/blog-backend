package com.blogger.blogcast.repository;

import com.blogger.blogcast.model.BlogUser;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<BlogUser, Long> {
}
