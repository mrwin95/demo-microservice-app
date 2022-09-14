package com.demo.authservice.model;

import lombok.Getter;
import lombok.ToString;

import java.util.List;
@Getter
@ToString
public class AuthResponse {
    private String username;
    private String status;
    private String methodType;
    private boolean authenticated;
    private String  token;
    private List<Role> roles;
}
