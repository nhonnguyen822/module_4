package com.example.thuc_hanh_3.repository;


import com.example.thuc_hanh_3.entiy.Customers;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CustomerRepository implements ICustomerRepository {
    private static final List<Customers> customersList = new ArrayList<>();

    static {
        customersList.add(new Customers(1, "Nguyen Van A", "a@gmail.com", "Ha Noi"));
        customersList.add(new Customers(2, "Le Thi B", "b@yahoo.com", "Da Nang"));
        customersList.add(new Customers(3, "Tran Van C", "c@outlook.com", "Ho Chi Minh"));
        customersList.add(new Customers(4, "Pham Thi D", "d@gmail.com", "Can Tho"));
        customersList.add(new Customers(5, "Hoang Van E", "e@gmail.com", "Hue"));
    }

    @Override
    public List<Customers> findAll() {
        return customersList;
    }

    @Override
    public void save(Customers customers) {
        customersList.add(customers);
    }

    @Override
    public boolean delete(int id) {
        for (int i = 0; i < customersList.size(); i++) {
            if (customersList.get(i).getId() == id) {
                customersList.remove(i);
                return true;
            }
        }
        return false;
    }

    @Override
    public void update(Customers customers) {
        for (Customers customer : customersList) {
            if (customer.getId() == customers.getId()) {
                customer.setName(customers.getName());
                customer.setEmail(customers.getEmail());
                customer.setAddress(customers.getAddress());
            }
        }
    }
}
