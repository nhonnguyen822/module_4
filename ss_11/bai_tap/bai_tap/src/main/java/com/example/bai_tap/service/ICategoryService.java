package com.example.bai_tap.service;

import com.example.bai_tap.entity.Category;

import java.util.List;

public interface ICategoryService {
    void add(Category category);

    List<Category> findAll();

    void delete(int id);

    void update(Category category);

    Category findById(int id);
}
