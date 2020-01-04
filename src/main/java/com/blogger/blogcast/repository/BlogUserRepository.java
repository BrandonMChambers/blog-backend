package com.blogger.blogcast.repository;

import com.blogger.blogcast.model.BlogUser;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BlogUserRepository extends CrudRepository<BlogUser, Long> {
    Optional<BlogUser> findByUsername(String username);
}
