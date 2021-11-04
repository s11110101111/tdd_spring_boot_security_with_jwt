package com.example.tdd_spring_sec_with_jwt_and_postgres.configes;/*
 * Copyright (c) 2021 MTS http://mts.ru
 */

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

/**
 * Http Filter for users
 */
@Configuration

public class UserFilter {

    @Bean
    public SecurityFilterChain httpSecurityFilterChain(HttpSecurity http) throws Exception {
        http
            .httpBasic(Customizer.withDefaults())
            .authorizeRequests(authz ->
                authz
//                    .anyRequest().permitAll()
                    .antMatchers("/api/about").permitAll()
                    .antMatchers("/api/users").hasRole("ADMIN")
                    .anyRequest().authenticated()
            );
    return http.build();
    }


}
