package com.example.bai_tap_blog_ajax.service;

import com.example.bai_tap_blog_ajax.entity.Category;

import java.util.List;

public interface ICategoryService {
    List<Category> findAll();

    Category findById(Long id);
}
