package com.example.demo.repository;


import com.example.demo.entiy.Customers;

import java.util.List;


public interface ICustomerRepository {
    List<Customers> findAll();
}
