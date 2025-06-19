package com.example.login.service;

import com.example.login.entity.Login;
import com.example.login.entity.User;

public interface IUserService {
    User checkLogin(Login login);
}
