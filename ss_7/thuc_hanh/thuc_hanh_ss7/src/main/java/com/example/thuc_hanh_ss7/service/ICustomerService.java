package com.example.thuc_hanh_ss7.service;

import com.example.thuc_hanh_ss7.entity.Customers;
import com.example.thuc_hanh_ss7.entity.Province;

public interface ICustomerService extends IGenerateService<Customers> {
    Iterable<Customers> findAllByProvince(Province province);
}
