package com.example.quan_ly_sach.service;

import com.example.quan_ly_sach.entity.BorrowCode;
import com.example.quan_ly_sach.repository.IBorrowCodeRepository;
import org.springframework.stereotype.Service;

@Service
public class BorrowBookService implements IBorrowBookService {
    private final IBorrowCodeRepository borrowCodeRepository;

    public BorrowBookService(IBorrowCodeRepository borrowCodeRepository) {
        this.borrowCodeRepository = borrowCodeRepository;
    }

    @Override
    public BorrowCode findByCode(String borrowCode) {
        return borrowCodeRepository.findByCode(borrowCode);
    }
}
