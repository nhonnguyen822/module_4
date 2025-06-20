package com.example.product.repository;

import com.example.product.entity.Products;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ProductsRepository implements IProductsRepository {
    private static final List<Products> productsList = new ArrayList<>();

    static {

        productsList.add(new Products(1, "iPhone 15", 25000, "Smartphone cao cấp", "Apple"));
        productsList.add(new Products(2, "Galaxy S24", 23000, "Điện thoại Android cao cấp", "Samsung"));
        productsList.add(new Products(3, "Xiaomi 13", 15000, "Giá rẻ cấu hình cao", "Xiaomi"));
        productsList.add(new Products(4, "Sony WH-1000XM5", 9000, "Tai nghe chống ồn", "Sony"));
        productsList.add(new Products(5, "MacBook Air M2", 32000, "Laptop mỏng nhẹ", "Apple"));
        productsList.add(new Products(6, "Dell XPS 13", 31000, "Laptop cao cấp", "Dell"));
        productsList.add(new Products(7, "iPad Pro", 28000, "Máy tính bảng mạnh mẽ", "Apple"));
        productsList.add(new Products(8, "Asus ROG Phone", 24000, "Điện thoại gaming", "Asus"));
        productsList.add(new Products(9, "Kindle Paperwhite", 5000, "Máy đọc sách", "Amazon"));
        productsList.add(new Products(10, "Apple Watch Series 9", 12000, "Đồng hồ thông minh", "Apple"));
    }


    @Override
    public List<Products> findAll() {
        return productsList;
    }

    @Override
    public void save(Products product) {
        productsList.add(product);
    }

    @Override
    public void update(Products product) {
        for (int i = 0; i < productsList.size(); i++) {
            if (productsList.get(i).getId() == product.getId()) {
                productsList.set(i, product);
                break;
            }
        }
    }

    @Override
    public void delete(int id) {
        for (int i = 0; i < productsList.size(); i++) {
            if (productsList.get(i).getId() == id) {
                productsList.remove(i);
                break;
            }
        }
    }

    @Override
    public Products findById(int id) {
        for (int i = 0; i < productsList.size(); i++) {
            if (productsList.get(i).getId() == id) {
                return productsList.get(i);
            }
        }
        return null;
    }

    @Override
    public List<Products> searchByName(String name) {
        List<Products> productsFindByName = new ArrayList<>();
        for (Products product : productsList) {
            if (product.getName().toLowerCase().contains(name.trim().toLowerCase())) {
                productsFindByName.add(product);
            }
        }
        return productsFindByName;
    }
}
