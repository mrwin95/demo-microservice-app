package com.demo.usersvc.model;

import com.demo.usersvc.entity.User;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class UserResponseModel extends AbstractResponseModel{

    private String userId;
    private User user;
    private List<User> userList;
}
