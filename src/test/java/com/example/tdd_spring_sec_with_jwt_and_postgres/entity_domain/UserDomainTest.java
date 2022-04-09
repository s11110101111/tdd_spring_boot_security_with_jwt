package com.example.tdd_spring_sec_with_jwt_and_postgres.entity_domain;

import static java.util.Arrays.asList;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 *
 */

@DisplayName("Тестируем UserDomain")
class UserDomainTest {


    private UserDomain getExpectedUserDomain() {
        UserDomain user = new UserDomain();
        user.setFirstName("Jim");
        user.setLastName("Carry");
        user.setUsername("jim");
        user.setRoles(asList(new Role("USER"),new Role("ADMIN")));
        return user;
    }

    @Test
    void getUsername() {
        UserDomain expectedUserDomain = getExpectedUserDomain();
        UserDomain userDomain = new UserDomain("Jim","Carry","jim",
            asList(new Role("USER"),new Role("ADMIN")));
        assertThat(userDomain).isEqualTo(expectedUserDomain);
        assertThat(userDomain.getRoles())
            .hasSize(2);
    }
}