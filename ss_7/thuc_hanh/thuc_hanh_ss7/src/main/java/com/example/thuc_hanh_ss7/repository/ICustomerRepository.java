package com.example.thuc_hanh_ss7.repository;

import com.example.thuc_hanh_ss7.entity.Customers;
import com.example.thuc_hanh_ss7.entity.Province;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICustomerRepository extends JpaRepository<Customers,Long> {
    Iterable<Customers> findAllByProvince(Province province);
}
