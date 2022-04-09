package com.example.tdd_spring_sec_with_jwt_and_postgres.entity_domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
/*
 * Copyright (c) 2021 MTS http://mts.ru
 */

/**
 * Test user domain
 */
class UserDomainTest {
 private UserDomain expectedUser;
    @BeforeEach
    void setUp() {

        expectedUser = new UserDomain("Jim Carry","jim");

    }

    @Test
    @DisplayName("create user list")
    void userDomainTest(){
        UserDomain user = new UserDomain();
        user.setUsername("jim");
        user.setName("Jim Carry");
        assertThat(user.getUsername()).isEqualTo(expectedUser.getUsername());


    }

}