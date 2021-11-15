package com.example.tdd_spring_sec_with_jwt_and_postgres.api_controllers;

import com.example.tdd_spring_sec_with_jwt_and_postgres.UserNotFoundException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *Test controller
 */
@RestController
public class ErrorController {
    @GetMapping("/error")
public String getError(){
        throw  new UserNotFoundException();
    }
}
