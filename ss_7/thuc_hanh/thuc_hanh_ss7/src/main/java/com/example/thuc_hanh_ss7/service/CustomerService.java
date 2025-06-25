package com.example.thuc_hanh_ss7.service;

import com.example.thuc_hanh_ss7.entity.Customers;
import com.example.thuc_hanh_ss7.entity.Province;
import com.example.thuc_hanh_ss7.repository.ICustomerRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class CustomerService implements ICustomerService {
    private ICustomerRepository customerRepository;

    public CustomerService(ICustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public Iterable<Customers> findAll() {
        return customerRepository.findAll();
    }

    @Override
    public void save(Customers customers) {
        customerRepository.save(customers);
    }

    @Override
    public Optional<Customers> findById(Long id) {
        return customerRepository.findById(id);
    }

    @Override
    public void remove(Long id) {
        customerRepository.deleteById(id);
    }

    @Override
    public Iterable<Customers> findAllByProvince(Province province) {
        return customerRepository.findAllByProvince(province);
    }
}
