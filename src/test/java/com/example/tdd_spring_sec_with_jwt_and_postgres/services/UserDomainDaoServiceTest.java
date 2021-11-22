package com.example.tdd_spring_sec_with_jwt_and_postgres.services;

import static org.assertj.core.api.Assertions.assertThat;

import com.example.tdd_spring_sec_with_jwt_and_postgres.repository_dao.UserDomainDao;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

/**
 *
 */
@ExtendWith(SpringExtension.class)
@ContextConfiguration
class UserDomainDaoServiceTest {

    @Mock
    UserDomainDao userDomainDao;
    @MockBean
    UserDomainDaoService userDomainDaoService;





    @Test
    void getAllUsers() {

    assertThat(userDomainDaoService.getAllUsers().get(0).getUsername()).isEqualTo("jim");

    }
}