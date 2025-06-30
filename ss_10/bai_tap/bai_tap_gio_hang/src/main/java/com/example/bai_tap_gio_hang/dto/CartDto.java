package com.example.bai_tap_gio_hang.dto;

import com.example.bai_tap_gio_hang.entity.Products;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.text.NumberFormat;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class CartDto {
    private Map<Products, Integer> products = new HashMap<>();

    private boolean checkItemInCart(Products product) {
        return products.containsKey(product);
    }

    private Map.Entry<Products, Integer> selectItemInCart(Products product) {
        for (Map.Entry<Products, Integer> productsIntegerEntry : products.entrySet()) {
            if (productsIntegerEntry.getKey().equals(product)) {
                return productsIntegerEntry;
            }
        }
        return null;
    }

    public void addProduct(Products product) {
        if (!checkItemInCart(product)) {
            products.put(product, 1);
        } else {
            for (Map.Entry<Products, Integer> productsIntegerEntry : products.entrySet()) {
                if (productsIntegerEntry.getKey().equals(product)) {
                    products.put(product, productsIntegerEntry.getValue() + 1);
                    break;
                }
            }
        }
    }

    public void subProduct(Products product) {
        if (products.containsKey(product)) {
            int quantity = products.get(product);
            if (quantity > 1) {
                products.put(product, quantity - 1);
            } else {
                products.remove(product);
            }
        }
    }

    public Integer countProductQuantity() {
        Integer productQuantity = 0;
        for (Map.Entry<Products, Integer> entry : products.entrySet()) {
            productQuantity += entry.getValue();
        }
        return productQuantity;
    }

    public Integer countItemQuantity() {
        return products.size();
    }

    public Integer countTotalPayment() {
        int payment = 0;
        for (Map.Entry<Products, Integer> entry : products.entrySet()) {
            payment += (int) (entry.getKey().getPrice() * entry.getValue());
        }
        return payment;
    }

    public String getFormattedCountTotalPayment() {
        NumberFormat vnFormat = NumberFormat.getInstance(new Locale("vi", "VN"));
        return vnFormat.format(countTotalPayment()) + " ₫";
    }
    
}
