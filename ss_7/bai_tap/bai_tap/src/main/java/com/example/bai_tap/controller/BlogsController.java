package com.example.bai_tap.controller;

import com.example.bai_tap.entity.Blogs;
import com.example.bai_tap.entity.Category;
import com.example.bai_tap.entity.Users;
import com.example.bai_tap.service.IBlogsService;
import com.example.bai_tap.service.ICategoryService;
import com.example.bai_tap.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/home")
public class BlogsController {
    private final IBlogsService blogsService;
    @Autowired
    private IUserService userService;
    @Autowired
    private ICategoryService categoryService;

    public BlogsController(IBlogsService blogsService) {
        this.blogsService = blogsService;
    }

    @GetMapping("")
    public String home(@RequestParam(required = false, defaultValue = "0") int page,
                       @RequestParam(required = false, defaultValue = "6") int size,
                       @RequestParam(required = false, defaultValue = "") String searchName,
                       @RequestParam(required = false, defaultValue = "0") int categoryId, Model model) {

        Sort sort = Sort.by(Sort.Direction.ASC, "created_at").and(Sort.by(Sort.Direction.ASC, "title"));
        Pageable pageable = PageRequest.of(page, size, sort);
        Page<Blogs> blogsPage = blogsService.searchByTitle(searchName, categoryId, pageable);
        model.addAttribute("blogsPage", blogsPage);
        model.addAttribute("categoryList", categoryService.findAll());
        return "blog/list";
    }

    @GetMapping("/create")
    public String showCreate(Model model) {
        model.addAttribute("categoryList", categoryService.findAll());
        model.addAttribute("blog", new Blogs());
        model.addAttribute("users", userService.findAll());
        model.addAttribute("categoryList", categoryService.findAll());
        return "blog/create";
    }

    @PostMapping("/create")
    public String create(@ModelAttribute Blogs blog, @RequestParam int userId, @RequestParam int categoryId, RedirectAttributes redirectAttributes) {
        redirectAttributes.addFlashAttribute("success", "create success");
        Users selectedUser = new Users();
        selectedUser.setId(userId);          // gán id người dùng được chọn
        blog.setUsers(selectedUser);
        Category category = new Category();
        category.setId(categoryId);
        blog.setCategory(category);
        blogsService.add(blog);
        return "redirect:/home";
    }

    @GetMapping("/update/{id}")
    public String showUpdate(@PathVariable int id, Model model) {
        Blogs blog = blogsService.findById(id);
        model.addAttribute("blog", blog);
        model.addAttribute("users", userService.findAll());
        model.addAttribute("categoryList", categoryService.findAll());
        return "blog/update";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute Blogs blog, RedirectAttributes redirectAttributes) {
        redirectAttributes.addFlashAttribute("success", "update success");
        blogsService.update(blog);
        return "redirect:/home";
    }


    @PostMapping("/delete")
    public String delete(@RequestParam int id, RedirectAttributes redirectAttributes) {
        blogsService.delete(id);
        redirectAttributes.addFlashAttribute("success", "delete success");
        return "redirect:/home";
    }

    @GetMapping("/detail/{id}")
    public String detail(@PathVariable int id, Model model) {
        Blogs blog = blogsService.findById(id);
        model.addAttribute("blog", blog);
        return "blog/detail";
    }

}
