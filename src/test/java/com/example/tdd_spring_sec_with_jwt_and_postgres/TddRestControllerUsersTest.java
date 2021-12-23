package com.example.tdd_spring_sec_with_jwt_and_postgres;

import static java.util.Arrays.asList;

import com.example.tdd_spring_sec_with_jwt_and_postgres.entity_domain.Role;
import com.example.tdd_spring_sec_with_jwt_and_postgres.entity_domain.UserDomain;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

/**
 *
 */
@SpringBootTest
@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
@DisplayName("Тестируем контроллер пользователей:(Testing the user controller)")
public class TddRestControllerUsersTest {

    @Autowired
    WebApplicationContext context;
    MockMvc mockMvc;
    UserDomain expectedUser;

    @BeforeEach
    void setUp() {
        mockMvc = MockMvcBuilders
            .webAppContextSetup(context)
            .apply(SecurityMockMvcConfigurers.springSecurity())
            .build();
        expectedUser = getExpectedUserForTest();

    }

    private UserDomain getExpectedUserForTest() {
        UserDomain user = new UserDomain();
        user.setFirstName("Jim");
        user.setLastName("Carry");
        user.setUsername("jim");
        user.setRoles(asList(new Role("USER"), new Role("ADMIN")));

        return user;
    }

    @Test
    @DisplayName("Можем получить доступ к описанию контроллера пользователей"
        + "(We can access to about):")
        // не авторизованный пользователь может сделать запрос к about и получить ОК.
        // ExpectedBehavior ожидаемое поведение
    void unauthorizedUser_GetAbout_ReturnsOk() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/api/about"))
            .andDo(MockMvcResultHandlers.print())
            .andExpectAll(MockMvcResultMatchers.status().isOk(),
                MockMvcResultMatchers.content().string("About users!"));

    }

    @Test
    @DisplayName("Не авторизованный пользователь не имеет доступа к /users")
    void unauthorizedUser_GetUsers_ReturnUnauthorized() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/api/users"))
            .andDo(MockMvcResultHandlers.print())
            .andExpect(MockMvcResultMatchers.status().isUnauthorized());
    }

    @Test
    @DisplayName("Авторизованному пользователю без роли ADMIN не имеет доступ запрещен")
    @WithMockUser(roles = {"USER", "SUPER_USER"})
    void authorizedUserWithoutRoleAdmin_GetUsers_ReturnForbidden() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/api/users"))
            .andDo(MockMvcResultHandlers.print())
            .andExpect(MockMvcResultMatchers.status().isForbidden());

    }

    @Test
    @DisplayName("Авторизованный пользователь с ролью ADMIN имеет доступ к /users")
    @WithMockUser(roles = {"USER", "ADMIN"})
    void authorizedUserWithRoleAdmin_GetUsers_ReturnsOk() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/api/users"))
            .andDo(MockMvcResultHandlers.print())
            .andExpect(MockMvcResultMatchers.status().isOk());
    }

}
