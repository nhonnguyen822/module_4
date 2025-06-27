package com.example.quan_ly_sach.service;

import com.example.quan_ly_sach.entity.BorrowCode;

public interface IBorrowBookService {

    BorrowCode findByCode(String borrowCode);
}
