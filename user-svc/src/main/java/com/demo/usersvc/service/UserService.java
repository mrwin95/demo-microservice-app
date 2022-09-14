package com.demo.usersvc.service;

import com.demo.usersvc.entity.User;

import java.util.Optional;

public interface UserService {

    public Optional<User> findUserByUsername(String username);

    public User saveUser(User user);
}
