package com.example.bai_tap_blog_ajax.repository;

import com.example.bai_tap_blog_ajax.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICategoryRepository extends JpaRepository<Category, Long> {
}
