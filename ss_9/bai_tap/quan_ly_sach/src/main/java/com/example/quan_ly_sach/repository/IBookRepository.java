package com.example.quan_ly_sach.repository;

import com.example.quan_ly_sach.entity.Books;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


public interface IBookRepository extends JpaRepository<Books, Long> {
    @Query(value = "SELECT * FROM books",
            countQuery = "SELECT COUNT(*) FROM books",
            nativeQuery = true)
    Page<Books> findAllAvailableBooks(Pageable pageable);
}
