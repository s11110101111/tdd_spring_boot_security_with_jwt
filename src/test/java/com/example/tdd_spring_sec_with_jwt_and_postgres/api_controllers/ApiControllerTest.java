package com.example.tdd_spring_sec_with_jwt_and_postgres.api_controllers;

import static java.util.Arrays.asList;
import static org.assertj.core.api.Assertions.assertThat;

import com.example.tdd_spring_sec_with_jwt_and_postgres.dto.UserDomainDto;
import com.example.tdd_spring_sec_with_jwt_and_postgres.services.UserDomainDaoService;
import java.util.Collections;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.BDDMockito;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

/**
 *Модульное тестирование контроллера
 * Unit testing the controller
 *
 */
@ExtendWith(MockitoExtension.class)

class ApiControllerTest {
       @Mock
    UserDomainDaoService userDomainDaoService;
        @Mock
        ApiController apiController;
        List<UserDomainDto> expectedResponse = Collections.singletonList(
            new UserDomainDto("Jim Carry", "jim", asList("USER", "ADMIN")));

    @BeforeEach
    void setUp(){

        this.apiController = new ApiController(userDomainDaoService);
    }


    @Test
    @DisplayName("should call service")
    void shouldReturnUsers(){
        List<UserDomainDto> users = Collections.singletonList(
            new UserDomainDto("Jim Carry", "jim", asList("USER", "ADMIN")));
        BDDMockito.given(userDomainDaoService.getAllUsers()).willReturn(users);
        assertThat(apiController.getUsers()).isEqualTo(expectedResponse);
        BDDMockito.verify(userDomainDaoService).getAllUsers();
    }

}