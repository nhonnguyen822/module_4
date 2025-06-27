package com.example.quan_ly_sach.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "borrow_code")
public class BorrowCode {
    @Id
    private String code;

    @ManyToOne
    @JoinColumn(name = "book_id")
    private Books books;
}
