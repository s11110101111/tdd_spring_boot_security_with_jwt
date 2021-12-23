package com.example.tdd_spring_sec_with_jwt_and_postgres.entity_domain;

import java.util.ArrayList;
import java.util.List;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Класс пользователя
 */
@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
public class UserDomain {

    private String firstName="";
    private String lastName = "";
    private String username = "";
    private List<Role> roles = new ArrayList<>();

    public UserDomain(String firstName, String lastName, String username,
        List<Role> roles) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.roles = roles;
    }
}

