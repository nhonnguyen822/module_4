package com.example.bai_tap_blog_ajax.service;

import com.example.bai_tap_blog_ajax.entity.Blog;
import com.example.bai_tap_blog_ajax.repository.IBlogsRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class BlogService implements IBlogService {
    private final IBlogsRepository blogsRepository;

    public BlogService(IBlogsRepository blogsRepository) {
        this.blogsRepository = blogsRepository;
    }

    @Override
    public Page<Blog> findAll(Pageable pageable) {
        return blogsRepository.findAll(pageable);
    }

    @Override
    public Blog findById(Long id) {
        return blogsRepository.findById(id).orElse(null);
    }

    @Override
    public void add(Blog blog) {
        blogsRepository.save(blog);
    }

    @Override
    public void update(Blog blog) {
        blogsRepository.save(blog);
    }

    @Override
    public void delete(Long id) {
        blogsRepository.deleteById(id);
    }
}
