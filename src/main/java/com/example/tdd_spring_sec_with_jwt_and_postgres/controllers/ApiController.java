package com.example.tdd_spring_sec_with_jwt_and_postgres.controllers;/*
 * Copyright (c) 2021 MTS http://mts.ru
 */

import static java.util.Arrays.asList;

import com.example.tdd_spring_sec_with_jwt_and_postgres.entity_domain.UserDomain;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * REST controller Api
 */
@RestController
@RequestMapping("/api")
public class ApiController {

    @GetMapping("/about")
    public String about() {
        return "About users!";

    }
@GetMapping("/users")
    public List<UserDomain> getUsers(){
    UserDomain user1 = new UserDomain("Jim Carry","jim");
    UserDomain user2 = new UserDomain("John Smith","john");
List<UserDomain> users = asList(user1, user2);
        return users;
}

}
