package com.demo.cloudgatewaysvc.model;

import lombok.Data;
import lombok.Getter;
import lombok.ToString;

import java.util.List;

@Data
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
