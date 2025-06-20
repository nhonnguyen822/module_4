package com.example.product.service;

import com.example.product.entity.Products;
import com.example.product.repository.IProductsRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductsService implements IProductsService {
    private final IProductsRepository productsRepository;

    public ProductsService(IProductsRepository productsRepository) {
        this.productsRepository = productsRepository;
    }

    @Override
    public List<Products> findAll() {
        return productsRepository.findAll();
    }

    @Override
    public void save(Products product) {
        productsRepository.save(product);
    }

    @Override
    public void update(Products product) {
        productsRepository.update(product);
    }

    @Override
    public void delete(int id) {
        productsRepository.delete(id);
    }

    @Override
    public Products findById(int id) {
        return productsRepository.findById(id);
    }

    @Override
    public List<Products> searchByName(String name) {
        return productsRepository.searchByName(name);
    }
}
