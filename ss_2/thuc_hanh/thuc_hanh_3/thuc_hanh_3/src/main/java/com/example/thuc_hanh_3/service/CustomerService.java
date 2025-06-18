package com.example.thuc_hanh_3.service;


import com.example.thuc_hanh_3.entiy.Customers;
import com.example.thuc_hanh_3.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService implements ICustomerService {
    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public List<Customers> findAll() {
        return customerRepository.findAll();
    }

    @Override
    public void save(Customers customers) {
        customerRepository.save(customers);
    }

    @Override
    public boolean delete(int id) {
        return customerRepository.delete(id);
    }

    @Override
    public void update(Customers customers) {
        customerRepository.update(customers);
    }
}
