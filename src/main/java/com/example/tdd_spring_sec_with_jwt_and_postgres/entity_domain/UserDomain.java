package com.example.tdd_spring_sec_with_jwt_and_postgres.entity_domain;

import java.util.ArrayList;
import java.util.List;
import lombok.EqualsAndHashCode;
import lombok.Getter;

/**
 * Entity user domain
 */
@Getter
@EqualsAndHashCode
public class UserDomain {

    private final String name;
    private final   String username;
    private final java.util.List<String> roles;

    public UserDomain(String name, String username) {
        this.username = username;
        this.name= name;
    this.roles = new ArrayList<>();
    }

    public UserDomain(String name, String username, List<String> roles) {
        this.name = name;
        this.username = username;
        this.roles = roles;
    }
}
