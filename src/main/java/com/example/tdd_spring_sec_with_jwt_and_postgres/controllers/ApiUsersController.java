package com.example.tdd_spring_sec_with_jwt_and_postgres.controllers;

import static java.util.Arrays.asList;

import com.example.tdd_spring_sec_with_jwt_and_postgres.entity_domain.Role;
import com.example.tdd_spring_sec_with_jwt_and_postgres.entity_domain.UserDomain;
import java.util.Collections;
import java.util.List;
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
    public Iterable<UserDomain> getUsers(){
        return getUsersDomain();
    }
    List<UserDomain> getUsersDomain(){
        UserDomain userDomain1 = new UserDomain("Jim","Carry","jim",asList(new Role("USER"),new Role("ADMIN")));
        UserDomain userDomain2 = new UserDomain("John","Smith","john", Collections.singletonList(new Role("USER")));
        return asList(userDomain1,userDomain2);
    }

}
