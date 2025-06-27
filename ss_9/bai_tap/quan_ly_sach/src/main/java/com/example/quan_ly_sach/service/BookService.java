package com.example.quan_ly_sach.service;

import com.example.quan_ly_sach.entity.Books;
import com.example.quan_ly_sach.entity.BorrowCode;
import com.example.quan_ly_sach.repository.IBookRepository;
import com.example.quan_ly_sach.repository.IBorrowCodeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService implements IBookService {
    private final IBookRepository bookRepository;
    @Autowired
    private IBorrowCodeRepository borrowCodeRepository;

    public BookService(IBookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public Books findById(Long id) {
        return bookRepository.findById(id).orElse(null);
    }

    @Override
    public void borrowBooks(Long id, String borrowCode) {
        Books books = bookRepository.findById(id).orElse(null);
        if (books != null && books.getQuantity() > 0) {
            books.setQuantity(books.getQuantity() - 1);
            bookRepository.save(books);
        }
        BorrowCode borrowCode1 = new BorrowCode();
        borrowCode1.setCode(borrowCode);
        borrowCode1.setBooks(books);
        borrowCodeRepository.save(borrowCode1);
    }

    @Override
    public void returnBooks(BorrowCode borrowCode) {
        Books books = borrowCode.getBooks();
        books.setQuantity(books.getQuantity() + 1);
        bookRepository.save(books);
        borrowCodeRepository.delete(borrowCode);
    }

    @Override
    public Page<Books> findAllAvailableBooks(Pageable pageable) {
        return bookRepository.findAllAvailableBooks(pageable);
    }
}
