package com.example.tdd_spring_sec_with_jwt_and_postgres.controllers;/*
 * Copyright (c) 2021 MTS http://mts.ru
 */

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * User controller
 */
@RestController
@RequestMapping("/api")
public class UserController {

    @GetMapping(value = "/about")
    public String getAbout() {
        return "It about users";
    }
    @GetMapping("/users")
    public String getAllUsers(){
        return "Users List, for admin";
    }
}
