package com.example.may_tinh.service;

import com.example.may_tinh.common.DivisionByZeroException;
import org.springframework.stereotype.Service;

@Service
public class CalculatorService {
    public double calculator(int num1, int num2, String cal) {
        double result = 0;
        switch (cal) {
            case "add":
                result = num1 + num2;
                break;
            case "sub":
                result = num1 - num2;
                break;
            case "mul":
                result = num1 * num2;
                break;
            case "div":
                if (num2 != 0) {
                    result = (double) num1 / num2;
                } else {
                    throw new DivisionByZeroException("khong the chia cho 0");
                }
                break;
        }
        return result;
    }
}
