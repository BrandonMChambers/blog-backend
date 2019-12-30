package com.blogger.blogcast.service;

import com.blogger.blogcast.model.Timeline;
import com.blogger.blogcast.repository.TimelineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

@Service
public class TimelineService {

    TimelineRepository timelineRepository;

    @Autowired
    public TimelineService(TimelineRepository timelineRepository){
        this.timelineRepository = timelineRepository;

    }

    public ResponseEntity<Iterable<Timeline>> index() {
        return new ResponseEntity<>(timelineRepository.findAll(), HttpStatus.OK);
    }

    public ResponseEntity<Timeline> show(Long id) {
        return new ResponseEntity<>(timelineRepository.findById(id).get(), HttpStatus.OK);
    }

    public ResponseEntity<Timeline> create(Timeline timeline) {
        return new ResponseEntity<>(timelineRepository.save(timeline), HttpStatus.CREATED);
    }

    public ResponseEntity<Timeline> update(Long id, Timeline timeline) {
        Timeline originalTimeline = timelineRepository.findById(id).get();
        timeline.setTitle(timeline.getTitle());
        timelineRepository.save(timeline);
        return new ResponseEntity<>(originalTimeline, HttpStatus.OK);
    }

    public ResponseEntity<?> destroy(Long id) {
        timelineRepository.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
