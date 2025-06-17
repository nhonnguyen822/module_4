package com.example.demo.service;


import com.example.demo.entiy.Customers;
import com.example.demo.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService  implements ICustomerService{
    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public List<Customers> findAll() {
        return customerRepository.findAll();
    }
}
