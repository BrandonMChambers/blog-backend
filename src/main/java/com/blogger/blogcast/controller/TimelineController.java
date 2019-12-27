package com.blogger.blogcast.controller;

import com.blogger.blogcast.model.Timeline;
import com.blogger.blogcast.service.TimelineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class TimelineController {

        private TimelineService timelineService;

        @Autowired
        public TimelineController(TimelineService timelineService) {
            this.timelineService = timelineService;
        }

        @GetMapping(value ="/timeline")
        public ResponseEntity<Iterable<Timeline>> index() {
            return new ResponseEntity<>(timelineService.index(), HttpStatus.OK);
        }

        @GetMapping(value ="/timeline/{id}")
        public ResponseEntity<Timeline> show(@PathVariable Long id) {
            return new ResponseEntity<>(timelineService.show(id), HttpStatus.OK);
        }

        @PostMapping(value ="/timeline")
        public ResponseEntity<Timeline> create(@RequestBody Timeline timeline) {
            return new ResponseEntity<>(timelineService.create(timeline), HttpStatus.CREATED);
        }

        @PutMapping(value ="/timeline/{id}")
        public ResponseEntity<Timeline> update(@PathVariable Long id,@RequestBody Timeline timeline) {
            return new ResponseEntity<>(timelineService.update(id, timeline), HttpStatus.OK);
        }


        @DeleteMapping(value ="/timeline/{id}")
        public ResponseEntity<Boolean> destroy(@PathVariable Long id) {
            return new ResponseEntity<>(timelineService.delete(id), HttpStatus.OK);
        }
    }

