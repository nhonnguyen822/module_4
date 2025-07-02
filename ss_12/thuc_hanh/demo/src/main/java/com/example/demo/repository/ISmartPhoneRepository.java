package com.example.demo.repository;

import com.example.demo.entity.Smartphone;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ISmartPhoneRepository  extends JpaRepository<Smartphone,Long> {

}
