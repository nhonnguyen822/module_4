package com.example.login.controller;


import com.example.login.entity.Users;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.net.http.HttpRequest;

@Controller
@SessionAttributes("user")
public class UsersController {
    @ModelAttribute("user")
    public Users setUpUserForm() {
        return new Users();
    }

    @GetMapping("/login")
    public String index(@CookieValue(value = "setUser", defaultValue = "") String setUser, Model model) {
        model.addAttribute("cookieValue", setUser);
        return "/login";
    }

    @PostMapping("doLogin")
    public String doLogin(@ModelAttribute("user") Users users,
                          @CookieValue(value = "setUser", defaultValue = "")
                          String setUser,
                          Model model,
                          HttpServletRequest httpServletRequest,
                          HttpServletResponse httpServletResponse) {
        if (users.getEmail().equals("admin@gmail.com") && users.getPassword().equals("123456")) {
            if (users.getEmail() != null) {
                setUser = users.getEmail();
            }
            Cookie cookie = new Cookie("setUser", setUser);
            cookie.setMaxAge(24 * 60 * 60);
            httpServletResponse.addCookie(cookie);

            model.addAttribute("cookieValue", setUser);
            model.addAttribute("message", "Login success. Welcome!");

        } else {
            users.setEmail("");
            model.addAttribute("cookieValue","");
            model.addAttribute("message", "Login failed. Try again.");
        }
        return "/login";
    }
}
