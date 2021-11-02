package com.example.tdd_spring_sec_with_jwt_and_postgres.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
/*
 * Copyright (c) 2021 MTS http://mts.ru
 */

/**
 *
 */
class UserDomainTest {
    UserDomain expectedUser;
    @BeforeEach
    void setUp() {
        expectedUser = new UserDomain ("Jim Carry","jim","123");
        expectedUser.setEmail("carry@gmail.com");
        expectedUser.setDescription("user admin");
    }
@Test
@DisplayName("can get username for domainUser")
    void getUsername(){
        UserDomain user = new UserDomain();
        user.setName("Jim Carry");
        user.setUsername("jim");
        user.setPassword("123");
        assertThat(user.getPassword()).isEqualTo(expectedUser.getPassword());
    }

    @Test @DisplayName("create user all construct")
    void createUser(){
        UserDomain user = new UserDomain("Jim Carry","jim","123","carry@gmail.com","user admin");
        assertThat(user).isEqualTo(expectedUser);
    }
}