package com.example.tdd_spring_sec_with_jwt_and_postgres.controllers;/*
 * Copyright (c) 2021 MTS http://mts.ru
 */

import static java.util.Arrays.asList;

import com.example.tdd_spring_sec_with_jwt_and_postgres.domain.UserDomain;
import java.util.List;
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
    public List<UserDomain> getAllUsers(){
        UserDomain user = new UserDomain("Jim Carry","jim","123","carry@gmail.com","user admin");
        UserDomain user1 = new UserDomain("John Smith","john","123","smith@gmail.com","user");
        return asList(user, user1);
    }
}
