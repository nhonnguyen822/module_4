package com.example.bai_tap.repository;

import com.example.bai_tap.entity.Customers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ICustomerRepository extends JpaRepository<Customers, Integer> {
    List<Customers> findCustomersByNameContaining(String searchName);

    @Query(value = "select * from customers where name like concat('%',:searchName,'%');", nativeQuery = true)
    List<Customers> searchByName(@Param("searchName") String searchName);
}
