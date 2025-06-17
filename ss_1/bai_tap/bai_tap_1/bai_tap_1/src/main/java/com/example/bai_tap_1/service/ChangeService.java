package com.example.bai_tap_1.service;

import org.springframework.stereotype.Service;

@Service
public class ChangeService {
    public double calculator(int vnd) {
        return (double) vnd / 25000;
    }
}
