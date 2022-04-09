package com.example.tdd_spring_sec_with_jwt_and_postgres.api_controllers;

import com.example.tdd_spring_sec_with_jwt_and_postgres.dto.UserDomainDto;
import com.example.tdd_spring_sec_with_jwt_and_postgres.services.UserDomainDaoService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * REST controller for api
 */
@RestController
@RequestMapping("/api")
public class ApiController {

    private final UserDomainDaoService service;

    public ApiController(
        @Qualifier("userDomainDaoServiceImpl") @Autowired
        UserDomainDaoService service) {
        this.service = service;
    }

    @GetMapping("/about")
    public String getAbout() {
        return "About users!";
    }
    @GetMapping("/users")
    public List<UserDomainDto> getUsers(){

        return service.getAllUsers();
    }



}
