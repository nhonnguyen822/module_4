package com.example.bai_tap.service;

import com.example.bai_tap.entity.Category;
import com.example.bai_tap.repository.IBlogsRepository;
import com.example.bai_tap.repository.ICategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService implements ICategoryService {
    private final ICategoryRepository categoryRepository;
    @Autowired
    private IBlogsRepository blogsRepository;

    public CategoryService(ICategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public void add(Category category) {
        categoryRepository.save(category);
    }

    @Override
    public List<Category> findAll() {
        return categoryRepository.findAll();
    }

    @Override
    public void delete(int id) {
        Long count = blogsRepository.countByCategory_Id(id);
        if(count==0){
            categoryRepository.deleteById(id);
        }
    }

    @Override
    public void update(Category category) {
        categoryRepository.save(category);
    }

    @Override
    public Category findById(int id) {
        return categoryRepository.findById(id).orElse(null);
    }
}
