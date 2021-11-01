package com.example.tdd_spring_sec_with_jwt_and_postgres;

import static org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers.springSecurity;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@SpringBootTest
@DisplayName("Ma in tdd test for users controller")
@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
class TddSpringSecWithJwtAndPostgresApplicationTests {

    @Autowired
    private WebApplicationContext context;
    private MockMvc mockMvc;

    @BeforeEach
    private void setUp() {
        mockMvc = MockMvcBuilders
            .webAppContextSetup(context)
            .apply(springSecurity())
            .build();
    }

    @Test
    @DisplayName("can get end point about")
    @WithMockUser(username = "admin", password = "123", roles = {"USER", "ADMIN"})
    void contextLoadsRequestAboutTest() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/api/about"))
            .andDo(print())
            .andExpect(status().isOk())
            .andExpect(MockMvcResultMatchers.jsonPath("$").value("It about users"));
    }

    @Test
    @DisplayName("can get end point about user unAuthorized")
        //  @WithMockUser(username = "admin",password = "123",roles = {"USER","ADMIN"})
    void contextLoadsRequestAboutUnAuthorizedTest() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/api/about"))
            .andDo(print())
            .andExpect(status().isOk())
            .andExpect(MockMvcResultMatchers.jsonPath("$").value("It about users"));
    }

    @Test
    @DisplayName("can get end point /users user Authorized")
    @WithMockUser(username = "admin", password = "123", roles = {"USER", "ADMIN"})
    void canGetUsersListAuthenticatedUserAdminTest() throws Exception {
        User user = new User("Jim Carry","jim","123");
        this.mockMvc.perform(MockMvcRequestBuilders.get("/api/users"))
            .andDo(print())
            .andExpect(status().isOk())
            //    .andExpect(content().string("Users List, for admin"));
            .andExpect(MockMvcResultMatchers.jsonPath("$[0].getUsername").value(user.getUsername()));
    }

    @Test
    @DisplayName("can not get /users UnAuthenticated user")
    void canNotGetUsersListUnAuthenticatedUserThenReturn401Test() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/users"))
            .andDo(MockMvcResultHandlers.print())
            .andExpect(status().isUnauthorized());
    }

}
