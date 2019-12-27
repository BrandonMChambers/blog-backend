package com.blogger.blogcast.repository;

import com.blogger.blogcast.model.Timeline;
import org.springframework.data.repository.CrudRepository;

public interface TimelineRepository extends CrudRepository<Timeline, Long> {
}
