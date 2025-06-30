package com.example.demo.controller;

import com.example.demo.entity.Cart;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("cart")
public class ShopController {
    @ModelAttribute("cart")
    public Cart setUpCart() {
        return new Cart();
    }

    @GetMapping("/shopping-cart")
    public String showCart(@ModelAttribute Cart cart, Model model) {
        model.addAttribute("cart", cart);
        return "/cart";
    }
}
