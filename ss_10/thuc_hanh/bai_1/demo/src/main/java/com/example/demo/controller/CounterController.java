package com.example.demo.controller;

import com.example.demo.entity.Count;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;


@Controller
@SessionAttributes("counter")
public class CounterController {


    @ModelAttribute("counter")
    public Count count() {
        return new Count();
    }

    @GetMapping
    public String get(@ModelAttribute("counter") Count count) {
        count.increment();
        return "/index";
    }
}
