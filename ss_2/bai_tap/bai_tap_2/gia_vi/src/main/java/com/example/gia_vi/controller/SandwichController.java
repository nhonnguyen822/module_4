package com.example.gia_vi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SandwichController {
    @GetMapping("home")
    public String home() {
        return "home";
    }

    @PostMapping("/home")
    public String detail(@RequestParam String[] condiment, Model model) {
        model.addAttribute("condiment", condiment);
        return "detail";
    }
}
