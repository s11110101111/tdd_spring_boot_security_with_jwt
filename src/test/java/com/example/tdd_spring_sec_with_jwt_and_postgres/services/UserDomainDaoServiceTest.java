package com.example.tdd_spring_sec_with_jwt_and_postgres.services;

import static java.util.Arrays.asList;
import static org.assertj.core.api.Assertions.assertThat;

import com.example.tdd_spring_sec_with_jwt_and_postgres.dto.UserDomainDto;
import com.example.tdd_spring_sec_with_jwt_and_postgres.repository_dao.UserDomainDao;
import java.util.Collections;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

/**
 *
 */
@ExtendWith(SpringExtension.class)
@ContextConfiguration
class UserDomainDaoServiceTest {

    @MockBean
    UserDomainDao userDomainDao;

    @Autowired
    UserDomainDaoService userDomainDaoService;
@Configuration
    public static class Config{
    @Bean
    public UserDomainDaoService getUserDaoService(){
        return new UserDomainDaoService() {
            @Override
            public List<UserDomainDto> getAllUsers() {
                return asList(
                    new UserDomainDto("Jim Carry", "jim", asList("USER", "ADMIN")),
                    new UserDomainDto("John Smith", "john", Collections.singletonList("USER"))
                );
            }
        };
    }

}

    @Test
    void getAllUsers() {

    assertThat(userDomainDaoService.getAllUsers().get(0).getUsername()).isEqualTo("jim");

    }
}