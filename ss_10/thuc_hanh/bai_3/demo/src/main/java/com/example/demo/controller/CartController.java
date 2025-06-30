package com.example.demo.controller;

import com.example.demo.entity.Cart;
import com.example.demo.entity.Product;
import com.example.demo.service.IProductService;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@SessionAttributes("cart")
public class CartController {
    private IProductService productService;

    public CartController(IProductService productService) {
        this.productService = productService;
    }

    @ModelAttribute("cart")
    public Cart setUpCart() {
        return new Cart();
    }

    @GetMapping("shop")
    public String showShop(Model model) {
        model.addAttribute("products", productService.findAll());
        return "/shop";
    }

    @GetMapping("/add/{id}")
    public String addToCart(@PathVariable Long id,
                            @ModelAttribute Cart cart,
                            @RequestParam String action,
                            HttpServletResponse response) {
        Optional<Product> productOptional = productService.findById(id);
        if (!productOptional.isPresent()) {
            return "/error_404";
        }
        if (action.equals("show")) {
            cart.addProduct(productOptional.get());
            return "redirect:/shopping-cart";
        }
        cart.addProduct(productOptional.get());
        return "redirect:/shop";
    }

    @GetMapping("/sub/{id}")
    public String subToCart(@PathVariable Long id,
                            @ModelAttribute Cart cart,
                            @RequestParam String action) {
        Optional<Product> productOptional = productService.findById(id);
        if (!productOptional.isPresent()) {
            return "/error_404";
        }
        if (action.equals("show")) {
            cart.subProduct(productOptional.get());
            return "redirect:/shopping-cart";
        }
        cart.subProduct(productOptional.get());
        return "redirect:/shop";
    }
}
