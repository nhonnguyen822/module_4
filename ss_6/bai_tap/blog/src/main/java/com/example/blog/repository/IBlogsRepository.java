package com.example.blog.repository;

import com.example.blog.entity.Blogs;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IBlogsRepository extends JpaRepository<Blogs, Integer> {

}
