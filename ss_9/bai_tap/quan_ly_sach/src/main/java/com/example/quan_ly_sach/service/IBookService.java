package com.example.quan_ly_sach.service;

import com.example.quan_ly_sach.entity.Books;
import com.example.quan_ly_sach.entity.BorrowCode;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface IBookService {

    Books findById(Long id);

    void borrowBooks(Long id, String borrowCode);

    void returnBooks(BorrowCode borrowCode);

    Page<Books> findAllAvailableBooks(Pageable pageable);

}
