package com.example.thuc_hanh_ss5.service;

import com.example.thuc_hanh_ss5.entity.Customers;

import java.util.List;

public interface ICustomerService {
    List<Customers> findAll();

    void save(Customers customer);

    void update( Customers customer);

    void delete(int id);

    Customers findById(int id);

    List<Customers> searchByName(String name);

}
