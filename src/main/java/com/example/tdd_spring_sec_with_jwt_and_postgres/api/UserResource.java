package com.example.tdd_spring_sec_with_jwt_and_postgres.api;/*
 * Copyright (c) 2021 MTS http://mts.ru
 */

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * REST контроллер для работы с пользователями
 */
@RestController
@RequestMapping("/api")
public class UserResource {

    @GetMapping("/about")
    public String aboutUsers() {
        return "API users";
    }
    @GetMapping("/users")
    public String getUsers(@AuthenticationPrincipal(expression = "username") String username) {
        return  username+ " is here";
    }

}
