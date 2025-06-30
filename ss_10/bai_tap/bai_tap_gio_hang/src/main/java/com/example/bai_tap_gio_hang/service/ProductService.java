package com.example.bai_tap_gio_hang.service;

import com.example.bai_tap_gio_hang.entity.Products;
import com.example.bai_tap_gio_hang.repository.IProductRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductService implements IProductService {
    private final IProductRepository productRepository;

    public ProductService(IProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Iterable<Products> findAll() {
        return productRepository.findAll();
    }

    @Override
    public Optional<Products> findById(Long id) {
        return productRepository.findById(id);
    }
}
