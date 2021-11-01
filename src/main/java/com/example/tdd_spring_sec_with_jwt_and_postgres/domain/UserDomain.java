package com.example.tdd_spring_sec_with_jwt_and_postgres.domain;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * User domain in my app
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDomain {
    private String name= "";
    private String username= "";
    private String password= "";
    private String email= "";
    private String description= "";


    public UserDomain(String name, String username, String password) {
        this.name= name;
        this.username= username;
        this.password= password;
    }
}
