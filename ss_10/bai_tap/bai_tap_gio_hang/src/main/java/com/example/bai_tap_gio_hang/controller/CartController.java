package com.example.bai_tap_gio_hang.controller;

import com.example.bai_tap_gio_hang.dto.CartDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("cart")
@SessionAttributes("cart")
public class CartController {
    @ModelAttribute("cart")
    public CartDto cartDto() {
        return new CartDto();
    }

    @GetMapping("")
    public String showCart(@ModelAttribute("cart") CartDto cartDto, Model model) {
        model.addAttribute("cart", cartDto);
        return "cart";
    }


}
