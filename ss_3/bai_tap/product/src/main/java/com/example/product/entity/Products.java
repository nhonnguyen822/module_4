package com.example.product.entity;

public class Products {
    private int id;
    private String name;
    private int price;
    private String describe;
    private String manufacture;

    public Products() {
    }

    public Products(int id, String name, int price, String describe, String manufacture) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.describe = describe;
        this.manufacture = manufacture;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }

    public String getManufacture() {
        return manufacture;
    }

    public void setManufacture(String manufacture) {
        this.manufacture = manufacture;
    }
}
