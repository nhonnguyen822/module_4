package com.example.bai_tap.repository;

import com.example.bai_tap.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserRepository extends JpaRepository<Users, Integer> {
}
