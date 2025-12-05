package com.korit.springboot.entity;


import lombok.Data;

@Data
public class UserEntity {
    private int userId;
    private String userName;
    private String password;
    private String name;
    private String email;
}
