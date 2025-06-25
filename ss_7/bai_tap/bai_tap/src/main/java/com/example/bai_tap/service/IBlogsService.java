package com.example.bai_tap.service;


import com.example.bai_tap.entity.Blogs;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IBlogsService {
    List<Blogs> findAll();
    Blogs findById(int id);
    void add(Blogs blog);
    void update(Blogs blog);
    void delete(int id);
    Page<Blogs> searchByTitle(@Param("searchName") String searchName, @Param("categoryId") int categoryId, Pageable pageable);
}
