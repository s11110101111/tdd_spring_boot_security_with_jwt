package com.example.tdd_spring_sec_with_jwt_and_postgres.domain;/*
 * Copyright (c) 2021 MTS http://mts.ru
 */

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * User
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

    private String name = "";
    private String username= "";
    private String email="";
    private boolean enabled=false;
    private String password="";
    private String description="";
    private boolean admin=false;

    public User(User user) {
        this.name = user.name;
        this.username = user.username;
        this.email = user.email;
        this.enabled = user.enabled;
        this.password = user.password;
        this.description = user.description;
        this.admin = user.admin;
    }
}
