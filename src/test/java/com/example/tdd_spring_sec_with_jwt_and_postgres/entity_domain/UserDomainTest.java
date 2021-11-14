package com.example.tdd_spring_sec_with_jwt_and_postgres.entity_domain;

import static java.util.Arrays.asList;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Test create user
 */

class UserDomainTest {
private UserDomain expectedUser;
    @BeforeEach
    void setUp() {
        expectedUser = new UserDomain("Jim Carry","jim", asList("USER","ADMIN"));
    }

    @Test
    void getUsername() {
        UserDomain user = new UserDomain("Jim Carry","jim");
        user.getRoles().add("USER");
        user.getRoles().add("ADMIN");
        assertThat(user).isEqualTo(expectedUser);
    }
}