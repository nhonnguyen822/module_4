package com.example.blog.service;

import com.example.blog.entity.Blogs;
import com.example.blog.repository.IBlogsRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogsService implements IBlogsService {
    private final IBlogsRepository blogsRepository;

    public BlogsService(IBlogsRepository blogsRepository) {
        this.blogsRepository = blogsRepository;
    }

    @Override
    public List<Blogs> findAll() {
        return blogsRepository.findAll();
    }

    @Override
    public Blogs findById(int id) {
        return blogsRepository.findById(id).orElse(null);
    }

    @Override
    public void add(Blogs blog) {
        blogsRepository.save(blog);
    }

    @Override
    public void update(Blogs blog) {
        blogsRepository.save(blog);
    }

    @Override
    public void delete(int id) {
        blogsRepository.deleteById(id);
    }
}
