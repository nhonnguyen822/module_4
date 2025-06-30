package com.example.bai_tap_gio_hang.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.text.NumberFormat;
import java.util.Locale;
import java.util.Objects;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "products")
public class Products {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String image;
    private double price;
    private String description;

    @Override
    public boolean equals(Object object) {
        if (object == null || getClass() != object.getClass()) return false;
        Products products = (Products) object;
        return Objects.equals(id, products.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    public String getFormattedPrice() {
        NumberFormat vnFormat = NumberFormat.getInstance(new Locale("vi", "VN"));
        return vnFormat.format(this.price) + " ₫";
    }

    public String getFormattedPrice(int price) {
        NumberFormat vnFormat = NumberFormat.getInstance(new Locale("vi", "VN"));
        return vnFormat.format(price) + " ₫";
    }
}

