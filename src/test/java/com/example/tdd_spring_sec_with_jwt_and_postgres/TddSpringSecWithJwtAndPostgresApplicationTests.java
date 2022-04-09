package com.example.tdd_spring_sec_with_jwt_and_postgres;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

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

@SpringBootTest
@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
@DisplayName("MainRESTAppTest")
class TddSpringSecWithJwtAndPostgresApplicationTests {

    @Autowired
    private WebApplicationContext context;
    private MockMvc mockMvc;
    private UserDomain expectedUser;
    @BeforeEach
    void setUp() {
        mockMvc = MockMvcBuilders
            .webAppContextSetup(context)
            .apply(SecurityMockMvcConfigurers.springSecurity())
            .build();
        expectedUser = new UserDomain("Jim Carry","jim");

    }

    @Test
        //  @WithMockUser(username = "jim")
    void contextLoads() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/api/about"))
            .andDo(print())
            .andExpect(MockMvcResultMatchers.status().isOk())
            .andExpect(MockMvcResultMatchers.jsonPath("$").value("About users!"))
            .andExpect(content().string("About users!"));

    }

    @Test
    @WithMockUser(username = "jim", roles = {"USER", "ADMIN"})
    void canLoadContextUsers() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/api/users"))
            .andDo(MockMvcResultHandlers.print())
            .andExpect(MockMvcResultMatchers.jsonPath("$[0].username")
                .value(expectedUser.getUsername()));
    }

    @Test
    @DisplayName("Can't  get users without authentication user")
    void canNotGetUsersWithoutAuthentication() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/users"))
            .andDo(MockMvcResultHandlers.print())
            .andExpect(MockMvcResultMatchers.status().isUnauthorized());
    }

}
