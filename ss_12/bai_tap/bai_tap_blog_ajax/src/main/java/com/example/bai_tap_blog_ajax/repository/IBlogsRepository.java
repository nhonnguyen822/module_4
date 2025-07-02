package com.example.bai_tap_blog_ajax.repository;

import com.example.bai_tap_blog_ajax.entity.Blog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IBlogsRepository extends JpaRepository<Blog,Long> {
}
