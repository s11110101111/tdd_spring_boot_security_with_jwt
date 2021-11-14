package com.example.tdd_spring_sec_with_jwt_and_postgres.api_controllers;

import static java.util.Arrays.asList;

import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * REST controller for api
 */
@RestController
@RequestMapping("/api")
public class ApiController {

    @GetMapping("/about")
    public String getAbout() {
        return "About users!";
    }
    @GetMapping("/users")
    public List<String> getUsers(){
        return asList("jim","john");
    }




}
