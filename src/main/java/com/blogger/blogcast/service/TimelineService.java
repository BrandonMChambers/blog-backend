package com.blogger.blogcast.service;

import com.blogger.blogcast.model.Timeline;
import com.blogger.blogcast.repository.TimelineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public class TimelineService {

    TimelineRepository timelineRepository;

    @Autowired
    public TimelineService(TimelineRepository timelineRepository){
        this.timelineRepository = timelineRepository;

    }

    public Iterable<Timeline> index(){
        return timelineRepository.findAll();
    }

    public Timeline create(Timeline timeline){
        return timelineRepository.save(timeline);
    }

    public Timeline show(Long id){
        return timelineRepository.findById(id).get();
    }
/*
    public Timeline show(String username) {
        return timelineRepository.findByBlogEntry(timeline).get();
    }

 */

    public Timeline show(Timeline timeline){
        return timelineRepository.save(timeline);
    }

    public Timeline update(Long id, Timeline timeline) {
        Timeline originalTimeline = timelineRepository.findById(id).get();
        timeline.setTitle(timeline.getTitle());
        return timelineRepository.save(timeline);
    }

    public Boolean delete(Long id){
        timelineRepository.deleteById(id);
        return true;
    }

}
