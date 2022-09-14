package com.demo.usersvc.controller;

import com.demo.usersvc.entity.User;
import com.demo.usersvc.model.UserResponseModel;
import com.demo.usersvc.service.UsersProcesses;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/user")
@Slf4j
@RequiredArgsConstructor
public class UserController {

    private final UsersProcesses usersProcesses;
    @PostMapping("/authenticate")
    public ResponseEntity<UserResponseModel> authenticate(@RequestBody User user){
        log.info("authenticate method");
        UserResponseModel responseModel = new UserResponseModel();
        User userVa = usersProcesses.validateUserLogin(user);
        if(user.isLogin()){

        }

        return null;
    }
}
