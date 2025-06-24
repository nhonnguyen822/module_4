package com.example.blog.service;


import com.example.blog.entity.Blogs;

import java.util.List;

public interface IBlogsService {
    List<Blogs> findAll();
    Blogs findById(int id);
    void add(Blogs blog);
    void update(Blogs blog);
    void delete(int id);
}
