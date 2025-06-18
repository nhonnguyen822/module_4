package com.example.thuc_hanh_3.service;


import com.example.thuc_hanh_3.entiy.Customers;

import java.util.List;

public interface ICustomerService {
    List<Customers> findAll();
    void save(Customers customers);
    boolean delete(int id);
    void update(Customers customers);

    default Customers findById(int id) {
        List<Customers> customersList = findAll();
        for (Customers customers : customersList) {
            if (customers.getId() == id) {
                return customers;
            }
        }
        return null;
    }
}
