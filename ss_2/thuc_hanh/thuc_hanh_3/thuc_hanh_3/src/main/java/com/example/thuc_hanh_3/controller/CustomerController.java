package com.example.thuc_hanh_3.controller;


import com.example.thuc_hanh_3.entiy.Customers;
import com.example.thuc_hanh_3.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;


@Controller
@RequestMapping("/customers")
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @GetMapping("")
    public String showList(Model model) {
        List<Customers> customersList = customerService.findAll();
        model.addAttribute("customersList", customersList);
        return "list";
    }

    @GetMapping("/create")
    public String showCreate() {
        return "create";
    }

    @PostMapping("/create")
    public String create(@ModelAttribute Customers customers) {
        customerService.save(customers);
        return "redirect:/customers";
    }

    @GetMapping("/detail")
    public String detail(@RequestParam int id, Model model) {
        Customers customers = customerService.findById(id);
        if (customers == null) {
            model.addAttribute("message", "not find id");
            return "list";
        }
        model.addAttribute("customers", customers);
        return "detail";
    }

    @GetMapping("/delete")
    public String detele(@RequestParam int id, RedirectAttributes redirectAttributes) {
        boolean isDelete = customerService.delete(id);
        if (!isDelete) {
            redirectAttributes.addFlashAttribute("message", "Xóa khách hàng khong thành công!");
        } else {
            redirectAttributes.addFlashAttribute("message", "Xóa khách hàng  thành công!");
        }
        return "redirect:/customers";
    }

    @GetMapping("/update/{id}")
    public String showUpdate(@PathVariable int id, Model model) {
        Customers customer = customerService.findById(id);
        model.addAttribute("customer", customer);
        return "update";
    }

    @PostMapping("/{id}")
    public String update(@PathVariable int id,
                         @ModelAttribute Customers customers) {
        customerService.update(customers);
        return "redirect:/customers";
    }
}
