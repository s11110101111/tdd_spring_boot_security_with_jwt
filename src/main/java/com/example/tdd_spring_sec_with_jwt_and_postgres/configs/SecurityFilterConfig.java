package com.example.tdd_spring_sec_with_jwt_and_postgres.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

/**
 *
 */
@EnableWebSecurity
public class SecurityFilterConfig {
@Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .httpBasic(Customizer.withDefaults())
            .authorizeRequests(authz ->
                authz
                    .antMatchers("/error").permitAll()
                    .antMatchers(HttpMethod.GET,"/api/about").permitAll()
                    .antMatchers(HttpMethod.GET,"/api/users").hasRole("ADMIN")
                    .anyRequest().authenticated()
                    );

            return http.build();
    }



}
