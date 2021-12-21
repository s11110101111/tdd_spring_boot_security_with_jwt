package com.example.tdd_spring_sec_with_jwt_and_postgres.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Rest controller for get information and control users
 */
@RestController
@RequestMapping("/api")
public class ApiUsersController {

    @GetMapping("/about")
    public String getAbout() {
        return "About users!";
    }

    @GetMapping("/users")
    public String getUsers(){
        return "Jim, John";
    }

}
