package com.example.tdd_spring_sec_with_jwt_and_postgres.entity_domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

import org.junit.jupiter.api.Test;

/**
 *
 */

class RoleTest {

    @Test
    void canSetRoleAdminReturnRoleAdmin() {
        Role expectedRole = getExpectedRoleAdmin();
        Role role = new Role();
        role.setRole("ADMIN");
        assertThat(role).isEqualTo(expectedRole);
    }

    private Role getExpectedRoleAdmin() {
     return new Role("ADMIN");

    }

    @Test
    void setRoleNullReturnException() {

        assertThatExceptionOfType(NullPointerException.class).isThrownBy(()->new Role(null));

    }
}