package com.example.tdd_spring_sec_with_jwt_and_postgres.config;/*
 * Copyright (c) 2021 MTS http://mts.ru
 */

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

/**
 * Configuration FilterChain Security
 */
@EnableWebSecurity
public class ConfigFilterSecurity {

@Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .httpBasic(Customizer.withDefaults())
            .authorizeRequests(authz ->
                authz
                    .antMatchers("/api/about").permitAll()
                    .antMatchers("/api/users").hasRole("ADMIN")
                    .anyRequest().authenticated()
            );

        return http.build();
    }


}
