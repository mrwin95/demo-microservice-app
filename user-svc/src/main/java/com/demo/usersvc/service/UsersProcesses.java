package com.demo.usersvc.service;

import com.demo.usersvc.entity.User;
import com.demo.usersvc.model.UserResponseModel;

public interface UsersProcesses {
    public User validateUserLogin(User user);

    public String generateToken(User user);

    public UserResponseModel createUser(User user);
}
