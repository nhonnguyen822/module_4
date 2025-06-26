package com.example.demo.service;

import com.example.demo.entity.Users;
import com.example.demo.repository.IUserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService implements IUserService {
    private IUserRepository userRepository;

    public UserService(IUserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void save(Users user) {
        userRepository.save(user);
    }
}
