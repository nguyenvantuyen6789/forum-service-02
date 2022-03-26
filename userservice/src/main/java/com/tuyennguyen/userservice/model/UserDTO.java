package com.tuyennguyen.userservice.model;

import lombok.Data;

import java.util.Set;

@Data
public class UserDTO {

    private Long userId;

    private String fullName;

    private String username;

    private String password;

    private Set<String> roles;

}
