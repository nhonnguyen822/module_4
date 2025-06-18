package com.example.login.repository;

import com.example.login.entity.Login;
import com.example.login.entity.User;

public interface IUserRepository {
    User checkLogin(Login login);
}
