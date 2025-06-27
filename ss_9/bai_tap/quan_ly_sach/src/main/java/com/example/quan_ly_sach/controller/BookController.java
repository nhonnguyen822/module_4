package com.example.quan_ly_sach.controller;

import com.example.quan_ly_sach.common.BorrowCodeGenerator;
import com.example.quan_ly_sach.entity.Books;
import com.example.quan_ly_sach.entity.BorrowCode;
import com.example.quan_ly_sach.exception.BookCodeException;
import com.example.quan_ly_sach.exception.BookQuantityException;
import com.example.quan_ly_sach.service.IBookService;
import com.example.quan_ly_sach.service.IBorrowBookService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/books")
public class BookController {
    private final IBookService bookService;
    private final BorrowCodeGenerator borrowCodeGenerator;
    private final IBorrowBookService borrowBookService;

    public BookController(IBookService bookService, BorrowCodeGenerator borrowCodeGenerator, IBorrowBookService borrowBookService) {
        this.bookService = bookService;
        this.borrowCodeGenerator = borrowCodeGenerator;
        this.borrowBookService = borrowBookService;
    }

    @GetMapping("")
    public String showList(@RequestParam(required = false, defaultValue = "0") int page,
                           @RequestParam(required = false, defaultValue = "5") int size,
                           Model model) {
        Pageable pageable = PageRequest.of(page, size);
        Page<Books> booksPage = bookService.findAllAvailableBooks(pageable);
        model.addAttribute("bookPage", booksPage);
        return "books/list";
    }

    @GetMapping("detail/{id}")
    public String showDetail(@PathVariable Long id, Model model) {
        Books book = bookService.findById(id);
        model.addAttribute("book", book);
        return "books/detail";
    }

    @PostMapping(value = "borrow/{id}")
    public String borrowBooks(@PathVariable Long id, RedirectAttributes redirectAttributes) throws BookQuantityException {
        String borrowCode = borrowCodeGenerator.generate();
        Books books = bookService.findById(id);
        bookService.borrowBooks(id, borrowCode);
        if (books.getQuantity() < 0) {
            throw new BookQuantityException("không còn sách");
        }
        redirectAttributes.addFlashAttribute("message", "Mượn sách thành công ! Mã Sách : " + borrowCode);
        return "redirect:/books";
    }

    @GetMapping("return")
    public String showReturnBook(Model model) {
        model.addAttribute("book", new Books());
        return "books/return-book";
    }

    @PostMapping("return")
    public String returnBook(@RequestParam String code, RedirectAttributes redirectAttributes) throws BookCodeException {
        BorrowCode borrowCode = borrowBookService.findByCode(code);
        if (borrowCode == null) {
            throw new BookCodeException("Mã muượn sách không đúng hoặc không tồn tại");
        }
        bookService.returnBooks(borrowCode);
        redirectAttributes.addFlashAttribute("message", "trả sách thành công");
        return "redirect:/books";
    }

    @ExceptionHandler(BookQuantityException.class)
    public String handleBookQuantityException(BookQuantityException ex, RedirectAttributes redirectAttributes) {
        redirectAttributes.addFlashAttribute("message", ex.getMessage());
        return "redirect:/books";
    }

    @ExceptionHandler(BookCodeException.class)
    public String handleBookCodeException(BookCodeException ex, RedirectAttributes redirectAttributes) {
        redirectAttributes.addFlashAttribute("message", ex.getMessage());
        return "redirect:/books";
    }
}
