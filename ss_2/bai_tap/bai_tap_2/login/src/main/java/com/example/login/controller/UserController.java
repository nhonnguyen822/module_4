package com.example.login.controller;

import com.example.login.entity.Login;
import com.example.login.entity.User;
import com.example.login.service.IUserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UserController {
    private IUserService userService;

    public UserController(IUserService userService) {
        this.userService = userService;
    }

    @GetMapping("/home")
    public String home(Model model) {
        model.addAttribute("login", new Login());
        return "home";
    }

    @PostMapping("/login")
    public String login(@ModelAttribute Login login, Model model) {
        User user = userService.checkLogin(login);
        if (user == null) {
            model.addAttribute("error", "sai tài khoản hoặc mật khẩu");
            return "home";
        }
        model.addAttribute("user", user);
        return "user";
    }
}

