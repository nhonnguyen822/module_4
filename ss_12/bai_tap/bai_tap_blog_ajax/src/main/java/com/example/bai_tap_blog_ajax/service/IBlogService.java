package com.example.bai_tap_blog_ajax.service;

import com.example.bai_tap_blog_ajax.entity.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IBlogService {
    Page<Blog> findAll(Pageable pageable);

    Blog findById(Long id);

    void add(Blog blog);

    void update(Blog blog);

    void delete(Long id);
}
