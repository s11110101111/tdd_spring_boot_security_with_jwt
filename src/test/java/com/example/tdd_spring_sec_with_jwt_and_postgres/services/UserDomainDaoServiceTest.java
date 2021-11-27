package com.example.tdd_spring_sec_with_jwt_and_postgres.services;

import static java.util.Arrays.asList;
import static org.assertj.core.api.Assertions.assertThat;

import com.example.tdd_spring_sec_with_jwt_and_postgres.entity_domain.UserDomain;
import com.example.tdd_spring_sec_with_jwt_and_postgres.repository_dao.UserDomainDao;
import java.util.Collections;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

/**
 *
 */
    @SpringBootTest
    @AutoConfigureMockMvc
class UserDomainDaoServiceTest {


    @MockBean
    UserDomainDao userDomainDao;
   @Autowired
    UserDomainDaoService userDomainDaoService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);

    }


    @Test
    void getAllUsers() {
        Mockito.when(userDomainDao.getAllUsers())
            .thenReturn(asList(new UserDomain("Jim Carry", "jim", asList("USER", "ADMIN")),
                new UserDomain("John Smith", "john", Collections.singletonList("USER"))));
       // System.out.println("============"+userDomainDao.getAllUsers().toString());

         assertThat(userDomainDaoService.getAllUsers().get(0).getUsername()).isEqualTo("jim");

    }
}