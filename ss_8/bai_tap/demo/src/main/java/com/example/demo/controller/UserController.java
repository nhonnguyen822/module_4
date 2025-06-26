package com.example.demo.controller;

import com.example.demo.entity.Users;
import com.example.demo.service.IUserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {
    private IUserService userService;

    public UserController(IUserService userService) {
        this.userService = userService;
    }

    @GetMapping("user")
    public String showForm(Model model) {
        model.addAttribute("user", new Users());
        return "index";
    }

    @PostMapping("/validateUser")
    public String checkValidation(@Validated @ModelAttribute("user") Users user, BindingResult bindingResult) {
        new Users().validate(user, bindingResult);
        if (bindingResult.hasErrors()) {
            return "index";
        } else {
            userService.save(user);
            return "redirect:result";
        }
    }

    @GetMapping("/result")
    public String showResultPage() {
        return "result";
    }
}
