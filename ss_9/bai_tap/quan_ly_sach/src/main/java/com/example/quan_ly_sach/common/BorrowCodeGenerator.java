package com.example.quan_ly_sach.common;

import org.springframework.stereotype.Component;

import java.util.concurrent.ThreadLocalRandom;

@Component
public class BorrowCodeGenerator {
    public String generate() {
        return String.format("%05d", ThreadLocalRandom.current().nextInt(0, 100000));
    }
}
