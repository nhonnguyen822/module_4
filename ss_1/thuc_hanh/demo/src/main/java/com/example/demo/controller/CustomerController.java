package com.example.demo.controller;

import com.example.demo.entiy.Customers;
import com.example.demo.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;


@Controller
public class CustomerController {
    @Autowired
    private CustomerService customerService;
    @GetMapping("/customers")
    public String showList(Model model){
        List<Customers> customersList=customerService.findAll();
        model.addAttribute("customersList",customersList);
        return "list";
    }
}
