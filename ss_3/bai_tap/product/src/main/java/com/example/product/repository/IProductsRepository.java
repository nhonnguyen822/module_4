package com.example.product.repository;

import com.example.product.entity.Products;

import java.util.List;

public interface IProductsRepository {
    List<Products> findAll();

    void save(Products product);

    void update( Products product);

    void delete(int id);

    Products findById(int id);

    List<Products> searchByName(String name);

}
