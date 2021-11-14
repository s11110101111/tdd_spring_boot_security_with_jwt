package com.example.tdd_spring_sec_with_jwt_and_postgres.api_controllers;

import static java.util.Arrays.asList;

import com.example.tdd_spring_sec_with_jwt_and_postgres.entity_domain.UserDomain;
import java.util.Collections;
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
    public List<UserDomain> getUsers(){

        return getAllUsers();
    }

    private List<UserDomain> getAllUsers() {
        UserDomain user1 = new UserDomain("Jim Carry","jim", asList("USER","ADMIN"));
        UserDomain user2 = new UserDomain("Johm Smith","john", Collections.singletonList("USER"));
        return asList(user1,user2);
    }


}
