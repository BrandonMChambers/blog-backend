package com.blogger.blogcast.controller;

import com.blogger.blogcast.model.Timeline;
import com.blogger.blogcast.service.TimelineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class TimelineController {

        private TimelineService timelineService;

        @Autowired
        public TimelineController(TimelineService timelineService) {
            this.timelineService = timelineService;
        }

        @GetMapping(value ="/timeline")
        public ResponseEntity<Iterable<Timeline>> index() {
            return timelineService.index();
        }

        @GetMapping(value ="/timeline/{id}")
        public ResponseEntity<Timeline> show(@PathVariable Long id) {
            return timelineService.show(id);
        }

        @PostMapping(value ="/timeline")
        public ResponseEntity<Timeline> create(@RequestBody Timeline timeline) {
            return timelineService.create(timeline);
        }

        @PutMapping(value ="/timeline/{id}")
        public ResponseEntity<Timeline> update(@PathVariable Long id,@RequestBody Timeline timeline) {
            return timelineService.update(id, timeline);
        }


        @DeleteMapping(value ="/timeline/{id}")
        public ResponseEntity<?> destroy(@PathVariable Long id) {
            return timelineService.destroy(id);
        }
    }

