package com.example.bai_tap_gio_hang.controller;

import com.example.bai_tap_gio_hang.dto.CartDto;
import com.example.bai_tap_gio_hang.entity.Products;
import com.example.bai_tap_gio_hang.service.IProductService;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.net.URLEncoder;
import java.util.Optional;

@Controller
@SessionAttributes("cart")
@RequestMapping("shop")
public class ShopController {
    @ModelAttribute("cart")
    public CartDto initCart() {
        return new CartDto();
    }

    private final IProductService productService;

    public ShopController(IProductService productService) {
        this.productService = productService;
    }

    @GetMapping("")
    public String showList(Model model,
                           @CookieValue(value = "lastVisited", required = false, defaultValue = "") String lastVisited) {
        model.addAttribute("products", productService.findAll());
        model.addAttribute("lastVisited", lastVisited);
        return "/shop";
    }

    @GetMapping("/detail/{id}")
    public String showDetail(@PathVariable Long id,
                             Model model) {
        Optional<Products> product = productService.findById(id);
        model.addAttribute("product", product);
        return "detail";
    }

    @GetMapping("/add/{id}")
    public String addToCart(@PathVariable Long id,
                            @SessionAttribute("cart") CartDto cart,
                            @RequestParam String action,
                            HttpServletResponse response) {
        Optional<Products> product = productService.findById(id);
        if (!product.isPresent()) {
            return "/error_404";
        }
        String encodedName = URLEncoder.encode(product.get().getName());
        Cookie cookie = new Cookie("lastAdd", encodedName);
        cookie.setMaxAge(24 * 60 * 60);
        cookie.setPath("/");
        response.addCookie(cookie);
        if (action.equals("show")) {
            cart.addProduct(product.get());
            return "redirect:/cart";
        }
        cart.addProduct(product.get());
        return "redirect:/shop";
    }

    @GetMapping("/sub/{id}")
    public String subToCart(@PathVariable Long id,
                            @SessionAttribute("cart") CartDto cart,
                            @RequestParam String action,
                            HttpServletResponse response) {
        Optional<Products> product = productService.findById(id);
        if (!product.isPresent()) {
            return "/error_404";
        }
        String encodedName = URLEncoder.encode(product.get().getName());
        Cookie cookie = new Cookie("lastAdd", encodedName);
        cookie.setMaxAge(24 * 60 * 60);
        cookie.setPath("/");
        response.addCookie(cookie);
        if (action.equals("show")) {
            cart.subProduct(product.get());
            return "redirect:/cart";
        }
        cart.subProduct(product.get());
        return "redirect:/shop";
    }

}
