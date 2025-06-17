package com.example.bai_tap_1.controller;

import com.example.bai_tap_1.service.ChangeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CalculatorController {
    @GetMapping("/result")
    public String form() {
        return "result";
    }
    @Autowired
    ChangeService changeService;

    @PostMapping("/result")

    public String result(@RequestParam("vnd") int vnd, Model model) {
        double usd = changeService.calculator(vnd);
        model.addAttribute("vnd", vnd);
        model.addAttribute("usd", usd);
        return "result";
    }
}
