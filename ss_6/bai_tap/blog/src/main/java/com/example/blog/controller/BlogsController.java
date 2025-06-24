package com.example.blog.controller;

import com.example.blog.entity.Blogs;
import com.example.blog.service.IBlogsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class BlogsController {
    private final IBlogsService blogsService;

    public BlogsController(IBlogsService blogsService) {
        this.blogsService = blogsService;
    }

    @GetMapping("home")
    public String home(Model model) {
        model.addAttribute("blogs", blogsService.findAll());
        return "blog/list";
    }

    @GetMapping("create")
    public String showCreate(Model model) {
        model.addAttribute("blog", new Blogs());
        return "blog/create";
    }

    @PostMapping("create")
    public String create(@ModelAttribute Blogs blog, RedirectAttributes redirectAttributes) {
        redirectAttributes.addFlashAttribute("success", "create success");
        blogsService.add(blog);
        return "redirect:home";
    }

    @GetMapping("update/{id}")
    public String showUpdate(@PathVariable int id, Model model) {
        Blogs blog = blogsService.findById(id);
        model.addAttribute("blog", blog);
        return "blog/update";
    }

    @PostMapping("update")
    public String update(@ModelAttribute Blogs blog, RedirectAttributes redirectAttributes) {
        redirectAttributes.addFlashAttribute("success", "update success");
        blogsService.update(blog);
        return "redirect:home";
    }


    @PostMapping("delete")
    public String delete(@RequestParam int id, RedirectAttributes redirectAttributes) {
        blogsService.delete(id);
        redirectAttributes.addFlashAttribute("success", "delete success");
        return "redirect:home";
    }

    @GetMapping("detail/{id}")
    public String detail(@PathVariable int id, Model model) {
        Blogs blog = blogsService.findById(id);
        model.addAttribute("blog", blog);
        return "blog/detail";
    }
}
