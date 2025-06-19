package com.example.login.service;

import com.example.login.entity.Login;
import com.example.login.entity.User;
import com.example.login.repository.IUserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService implements IUserService {
    private final IUserRepository userRepository;

    public UserService(IUserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User checkLogin(Login login) {
        return userRepository.checkLogin(login);
    }
}
