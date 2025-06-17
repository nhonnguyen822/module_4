package com.example.bai_tap_2.controller;

import com.example.bai_tap_2.service.IDictionaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class DictionaryController {
    @GetMapping("/search")
    public String searchForm() {
        return "search";
    }

    @Autowired
    IDictionaryService dictionaryService;

    @PostMapping("/search")
    public String result(@RequestParam("search") String search, Model model) {
        String result = dictionaryService.findByWord(search);
        if (result == null) {
            result = "không tìm thấy kết quả của " + search;
        }
        model.addAttribute("result", result);
        return "search";
    }
}
