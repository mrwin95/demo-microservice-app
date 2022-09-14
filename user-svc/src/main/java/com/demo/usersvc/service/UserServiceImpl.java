package com.demo.usersvc.service;

import com.demo.usersvc.entity.User;
import com.demo.usersvc.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{
    private final UserRepository userRepository;
    @Override
    public Optional<User> findUserByUsername(String username) {
        return userRepository.findUserByUsername(username);
    }

    @Override
    public User saveUser(User user) {
        return null;
    }
}
