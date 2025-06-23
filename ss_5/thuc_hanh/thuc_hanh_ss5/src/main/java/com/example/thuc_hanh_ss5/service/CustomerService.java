package com.example.thuc_hanh_ss5.service;

import com.example.thuc_hanh_ss5.entity.Customers;
import com.example.thuc_hanh_ss5.repository.ICustomerRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService implements ICustomerService {
    private final ICustomerRepository customerRepository;

    public CustomerService(ICustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public List<Customers> findAll() {
        return customerRepository.findAll();
    }

    @Override
    public void save(Customers customer) {
        customerRepository.save(customer);
    }

    @Override
    public void update(Customers customer) {
        customerRepository.update(customer);
    }

    @Override
    public void delete(int id) {
        customerRepository.delete(id);
    }

    @Override
    public Customers findById(int id) {
        return customerRepository.findById(id);
    }

    @Override
    public List<Customers> searchByName(String name) {
        return customerRepository.searchByName(name);
    }
}
