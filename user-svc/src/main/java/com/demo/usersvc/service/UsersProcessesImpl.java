package com.demo.usersvc.service;

import com.demo.usersvc.entity.User;
import com.demo.usersvc.exception.InvalidCredentialsException;
import com.demo.usersvc.exception.ResourceNotFoudException;
import com.demo.usersvc.model.UserResponseModel;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Component
public class UsersProcessesImpl implements UsersProcesses{

    private final UserService userService;

    private BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder(10);
    @Override
    public User validateUserLogin(User user) {
        Optional<User> userValidate = userService.findUserByUsername(user.getUsername());
        if(!userValidate.isPresent()){
            throw new ResourceNotFoudException("User not found");
        }

        User userData = userValidate.get();

        if(!passwordEncoder.matches(userData.getPassword(), user.getPassword())){
            throw  new InvalidCredentialsException("invalid username/password");
        }

        return userData;
    }

    @Override
    public String generateToken(User user) {
        Claims claims = Jwts.claims().setSubject(user.getUsername());
        Date expDate = new Date(System.currentTimeMillis() + 65000);
        return Jwts.builder().setClaims(claims).setIssuedAt(new Date()).setExpiration(expDate).signWith(SignatureAlgorithm.HS512,"").compact();
    }

    @Override
    public UserResponseModel createUser(User user) {
        UserResponseModel responseModel = new UserResponseModel();
        Optional<User> userExisted = userService.findUserByUsername(user.getUsername());

        return null;
    }
}
