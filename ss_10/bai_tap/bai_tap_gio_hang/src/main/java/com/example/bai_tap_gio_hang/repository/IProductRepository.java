package com.example.bai_tap_gio_hang.repository;

import com.example.bai_tap_gio_hang.entity.Products;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IProductRepository extends JpaRepository<Products, Long> {
}
