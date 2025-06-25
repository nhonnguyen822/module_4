package com.example.bai_tap.controller;

import com.example.bai_tap.entity.Category;
import com.example.bai_tap.service.ICategoryService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("category")
public class CategoryController {
    private ICategoryService categoryService;

    public CategoryController(ICategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping("")
    public String showCategoryPage(Model model) {
        model.addAttribute("categoryList", categoryService.findAll());
        return "category/list";
    }

    @GetMapping("/create")
    public String showCreate(Model model) {
        model.addAttribute("category", new Category());
        return "category/create";
    }

    @PostMapping("/create")
    public String create(@ModelAttribute Category category) {
        categoryService.add(category);
        return "redirect:/category";
    }

    @GetMapping("/update/{id}")
    public String showUpdate(@PathVariable int id, Model model) {
        model.addAttribute("category", categoryService.findById(id));
        return "category/update";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute Category category) {
        categoryService.update(category);
        return "redirect:/category";
    }

    @PostMapping("delete")
    public String delete(@RequestParam int id) {

        categoryService.delete(id);
        return "redirect:/category";
    }
}
