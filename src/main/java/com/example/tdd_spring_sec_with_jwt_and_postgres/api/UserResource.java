package com.example.tdd_spring_sec_with_jwt_and_postgres.api;/*
 * Copyright (c) 2021 MTS http://mts.ru
 */

import static java.util.Arrays.asList;

import com.example.tdd_spring_sec_with_jwt_and_postgres.domain.User;
import java.util.List;
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
    public List<User> getUsers(@AuthenticationPrincipal(expression = "username") String username) {

        return asList(
            new User("Jim Carry","jim","carry@gmail.com",true,"password","description good",true),
            new User("John Smith","john","smith@gmail.com",true,"password","description cool",false)
        );
    }

}
