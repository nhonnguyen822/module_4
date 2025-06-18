package com.example.thuc_hanh_3.repository;


import com.example.thuc_hanh_3.entiy.Customers;

import java.util.List;


public interface ICustomerRepository {
    List<Customers> findAll();

    void save(Customers customers);

    boolean delete(int id);
    void update(Customers customers);
}
