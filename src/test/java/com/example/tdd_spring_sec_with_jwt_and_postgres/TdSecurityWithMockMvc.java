package com.example.tdd_spring_sec_with_jwt_and_postgres;/*
 * Copyright (c) 2021 MTS http://mts.ru
 */

import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.user;
import static org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers.springSecurity;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

/**
 * Тестируем с моками
 */
@SpringBootTest
@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
@DisplayName("Мокаем получение списка пользователей")
public class TdSecurityWithMockMvc {

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
    @DisplayName("о получении списка пользователей")
    public void aboutReturnsUsers() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/api/users")
                .with(user("user")))
            .andDo(print())
            .andExpect(status().isOk())
            .andExpect(content().string("Jim is here!"));
    }

    @Test
    @DisplayName("Если пользователь не прошел аутентификацию")
    public void greetingWhenUnauthenticatedUserThenReturn401Test() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/api/users"))
            .andExpect(status().isUnauthorized());
    }

}
