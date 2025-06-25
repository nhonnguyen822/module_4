package com.example.bai_tap.service;

import com.example.bai_tap.entity.Blogs;
import com.example.bai_tap.repository.IBlogsRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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

    @Override
    public Page<Blogs> searchByTitle(String searchName, int categoryId, Pageable pageable) {
        if (categoryId == 0) {
            return blogsRepository.searchByTitle(searchName, pageable);
        }
        return blogsRepository.searchByTitle(searchName, categoryId, pageable);
    }
}
