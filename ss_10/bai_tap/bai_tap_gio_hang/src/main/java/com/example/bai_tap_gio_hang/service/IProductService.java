package com.example.bai_tap_gio_hang.service;

import com.example.bai_tap_gio_hang.entity.Products;

import java.util.Optional;

public interface IProductService {
    Iterable<Products> findAll();

    Optional<Products> findById(Long id);
}
