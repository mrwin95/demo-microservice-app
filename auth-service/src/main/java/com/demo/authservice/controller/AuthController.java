package com.demo.authservice.controller;

import com.demo.authservice.model.AuthResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@Slf4j
@RequestMapping("/auth")
public class AuthController {

    @GetMapping("/validateToken")
    public ResponseEntity<AuthResponse> validateToken(String token){
        log.info("Inside validateToken method of AuthController");
        return new ResponseEntity<AuthResponse>(HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(){
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
