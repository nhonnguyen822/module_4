package com.example.thuc_hanh_ss5.controller;

import com.example.thuc_hanh_ss5.entity.Customers;
import com.example.thuc_hanh_ss5.service.ICustomerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class CustomerController {
    private final ICustomerService customerService;

    public CustomerController(ICustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("home")
    public String home(Model model) {
        model.addAttribute("customersList", customerService.findAll());
        return "list";
    }

    @GetMapping("create")
    public String showCreateForm(Model model) {
        model.addAttribute("customer", new Customers());
        return "create";
    }

    @PostMapping("create")
    public String create(@ModelAttribute Customers customers, RedirectAttributes redirectAttributes) {
        redirectAttributes.addFlashAttribute("success", "Create Success");
        customerService.save(customers);
        return "redirect:home";
    }

    @PostMapping("delete")
    public String delete(@RequestParam int id, RedirectAttributes redirectAttributes) {
        customerService.delete(id);
        redirectAttributes.addFlashAttribute("success", "delete success");
        return "redirect:home";
    }

    @GetMapping("search")
    public String search(@RequestParam String search, Model model) {
        List<Customers> customersList = customerService.searchByName(search);
        model.addAttribute("customersList", customersList);
        return "list";
    }
}
