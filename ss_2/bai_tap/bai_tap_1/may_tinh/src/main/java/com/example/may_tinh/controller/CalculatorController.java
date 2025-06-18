package com.example.may_tinh.controller;

import com.example.may_tinh.common.DivisionByZeroException;
import com.example.may_tinh.service.CalculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;



@Controller
public class CalculatorController {
    @Autowired
    private CalculatorService calculatorService;

    @GetMapping("/home")
    public String home() {
        return "home";
    }

    @PostMapping("home")
    public String result(@RequestParam int num1, @RequestParam int num2, @RequestParam String operator, Model model) {
        try {
            double result = calculatorService.calculator(num1, num2, operator);
            model.addAttribute("result", result);
            return "home";
        } catch (DivisionByZeroException e) {
            model.addAttribute("result", e.getMessage());
            return "home";
        }
    }
}
