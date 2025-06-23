package com.example.product.controller;

import com.example.product.entity.Products;
import com.example.product.service.IProductsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class ProductsController {
    private final IProductsService productsService;

    public ProductsController(IProductsService productsService) {
        this.productsService = productsService;
    }

    @GetMapping("home")
    public String home(Model model) {
        List<Products> productsList = productsService.findAll();
        model.addAttribute("productsList", productsList);
        return "list";
    }

    @GetMapping("create")
    private String showCreateForm(Model model) {
        model.addAttribute("product", new Products());
        return "add";
    }

    @PostMapping("create")
    private String create(@ModelAttribute Products product) {
        productsService.save(product);
        return "redirect:/home";
    }

    @GetMapping("delete/{id}")
    public String delete(@PathVariable int id) {
        productsService.delete(id);
        return "redirect:/home";
    }

    @GetMapping("update/{id}")
    private String showUpdateForm(@PathVariable int id, Model model) {
        Products product = productsService.findById(id);
        model.addAttribute("product", product);
        return "update";
    }

    @PostMapping("update")
    private String update(@ModelAttribute Products product) {
        productsService.update(product);
        return "redirect:/home";
    }

    @GetMapping("detail/{id}")
    private String detail(@PathVariable int id, Model model) {
        Products product = productsService.findById(id);
        model.addAttribute("product", product);
        return "detail";
    }

    @GetMapping("/search")
    private String search(@RequestParam String search, Model model) {
        List<Products> productsList = productsService.searchByName(search);
        model.addAttribute("productsList", productsList);
        return "list";
    }
}

