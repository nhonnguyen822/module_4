package com.example.bai_tap.service;

import com.example.bai_tap.entity.Customers;

import java.util.List;

public interface ICustomerService {
    List<Customers> findAll();

    void save(Customers customer);

    void update( Customers customer);

    void delete(int id);

    Customers findById(int id);

    List<Customers> searchByName(String name);

}
