package com.blogger.blogcast.service;

import com.blogger.blogcast.model.Blog;
import com.blogger.blogcast.repository.BlogRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class BlogService {
    BlogRepository blogRepository;

    @Autowired
    public BlogService(BlogRepository blogRepository) {
        this.blogRepository = blogRepository;
    }

    public Iterable<Blog> findAll() {
        return blogRepository.findAll();
    }

    public Blog findById(Long id) {
        return blogRepository.findById(id).get();
    }

    public Blog create(Blog blog) {
        return blogRepository.save(blog);
    }

    public Blog update(Long id, Blog blog) {
        Blog original = blogRepository.findById(id).get();
        original.setBlogTitle(blog.getBlogTitle());
        return blogRepository.save(original);
    }

    public Boolean delete(Long id) {
        Blog blog = blogRepository.findById(id).get();
        blogRepository.delete(blog);
        return true;
    }

}
