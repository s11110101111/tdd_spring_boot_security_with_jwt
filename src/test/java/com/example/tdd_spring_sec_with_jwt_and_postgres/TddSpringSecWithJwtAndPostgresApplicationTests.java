package com.example.tdd_spring_sec_with_jwt_and_postgres;

import static java.util.Arrays.asList;
import static org.hamcrest.Matchers.hasSize;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.user;

import com.example.tdd_spring_sec_with_jwt_and_postgres.entity_domain.UserDomain;
import com.example.tdd_spring_sec_with_jwt_and_postgres.services.UserDomainDaoService;
import com.example.tdd_spring_sec_with_jwt_and_postgres.services.UserDomainService;
import java.util.Collections;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.BDDMockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
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
class TddSpringSecWithJwtAndPostgresApplicationTests {

    @Autowired
    private WebApplicationContext context;
    private MockMvc mockMvc;
    private UserDomain expectedUser;
    @MockBean
    UserDomainDaoService userDomainDaoService;

    @BeforeEach
    void setUp() {
        mockMvc = MockMvcBuilders
            .webAppContextSetup(context)
            .apply(SecurityMockMvcConfigurers.springSecurity())
            .build();
        expectedUser = new UserDomain("Jim Carry", "jim", asList("USER", "ADMIN"));

    }

    @Test
    void canGetAboutWithoutAuthentication() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/api/about"))
            .andDo(MockMvcResultHandlers.print())
            .andExpect(MockMvcResultMatchers.status().isOk())
            .andExpect(MockMvcResultMatchers.content().string("About users!"));

    }

    @Test
    void cantGetUsersWithoutAuthentication() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/api/users"))
            .andDo(MockMvcResultHandlers.print())
            .andExpect(MockMvcResultMatchers.status().isUnauthorized());
    }

    @Test
    @WithMockUser(username = "jim")
    void cantGetUsersWithoutAuthorizationIfNotAdmin() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/api/users"))
            .andDo(MockMvcResultHandlers.print())
            .andExpect(MockMvcResultMatchers.status().isForbidden());
    }

    @Test
    @DisplayName("Can get users is has role admin")
    @WithMockUser(username = "jim", roles = {"USER", "ADMIN"})
    void canGetUsersIfHasRoleAdmin() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/api/users"))
            .andDo(MockMvcResultHandlers.print())
            .andExpect(MockMvcResultMatchers.status().isOk())
            .andExpect(
                MockMvcResultMatchers.jsonPath("$[0].username").value(expectedUser.getUsername()));

    }

    @Test
    @DisplayName("Can get users is has role admin")
    void canGetUsersIfUserJimHasRoleAdmin() throws Exception {
        List<UserDomain> response = asList(new UserDomain("John Smith", "john", Collections.singletonList("USER")),
            new UserDomain("John Smith", "john", Collections.singletonList("USER"))
        );
        BDDMockito.given(UserDomainDaoServiceImpl.getAllUsers()).willReturn(response);
        mockMvc.perform(MockMvcRequestBuilders.get("/api/users")
                .with(user(new UserDomainService.UserDomainDetails(expectedUser))))
            .andDo(MockMvcResultHandlers.print())
            .andExpect(MockMvcResultMatchers.status().isOk())
            .andExpect(MockMvcResultMatchers.jsonPath("$", hasSize(2)))
            .andExpect(
                MockMvcResultMatchers.jsonPath("$[0].username").value(expectedUser.getUsername()));

        BDDMockito.verify(userDomainDaoService).getAllUsers();

    }

    @Test
    @DisplayName("Can get users with userDomainDaoService")
    void canGetUsersWithUserDomainDaoService() {

    }

    @Test
    @DisplayName("can get error")
    void canGetError() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/error"))
            .andDo(MockMvcResultHandlers.print())
            .andExpect(MockMvcResultMatchers.status().isNotFound());
    }

}
