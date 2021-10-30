package com.example.tdd_spring_sec_with_jwt_and_postgres;/*
 * Copyright (c) 2021 MTS http://mts.ru
 */

import static org.hamcrest.Matchers.hasSize;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.user;
import static org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers.springSecurity;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.example.tdd_spring_sec_with_jwt_and_postgres.domain.User;
import com.example.tdd_spring_sec_with_jwt_and_postgres.servicies.UserDetailsImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

/**
 * Тестируем с моками
 */
@SpringBootTest
@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
@DisplayName("Мокаем получение списка пользователей")
public class TddSecurityWithMockMvcTest {
ObjectMapper om = new ObjectMapper();
    @Autowired
    private WebApplicationContext context;
    private MockMvc mockMvc;

    @BeforeEach
    void setUp() {
        mockMvc = MockMvcBuilders
            .webAppContextSetup(context)
            .apply(springSecurity())
            .build();
    }

    @Test
    @DisplayName("об API пользователей")
    public void aboutUsers() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/api/about"))
            .andDo(print())
            .andExpect(status().isOk())
            .andExpect(content().string("API users"));

    }

    @Test
    @DisplayName("о получении списка пользователей пользователем")
    public void aboutReturnsUsers() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/api/about")
                .with(user("user")))
            .andDo(print())
            .andExpect(status().isOk())
            .andExpect(content().string("API users"));
    }

    @Test
    @DisplayName("Если пользователь не прошел аутентификацию")
    public void greetingWhenUnauthenticatedUserThenReturn401Test() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/api/users"))
            .andExpect(status().isUnauthorized());
    }
    @Test
    @DisplayName("Пользователь jim должен получить доступ")
    public void canGetAllUsersIfUserAuthenticated() throws Exception {
        User jim = new User();
        jim.setName("Jim Carry");
        jim.setUsername("jim");
        jim.setEmail("carry@gmail.com");
        jim.setEnabled(true);
        jim.setAdmin(true);
        jim.setDescription("description good");
 String jimJson = om.writeValueAsString(jim);
        System.out.println(jimJson);
        this.mockMvc.perform(MockMvcRequestBuilders.get("/api/users").with(
            user(new UserDetailsImpl.UserServiceDetails(jim))))
            .andExpect(status().isOk())
            .andDo(print())
            .andExpect(MockMvcResultMatchers.jsonPath("$",hasSize(2)))
            .andExpect(MockMvcResultMatchers.jsonPath("$[0].username").value("jim"));
    }

}
