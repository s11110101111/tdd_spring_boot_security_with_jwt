package com.example.tdd_spring_sec_with_jwt_and_postgres.config;/*
 * Copyright (c) 2021 MTS http://mts.ru
 */

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

/**
 * Конфигурационный файл настроек безопасности
 */

@EnableWebSecurity
public class SecurityConfig {


    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .httpBasic(Customizer.withDefaults())
            .authorizeRequests(auth -> auth
                .antMatchers("/api/about").permitAll()
                .anyRequest().authenticated());

        return http.build();
    }

}
