package com.example.tdd_spring_sec_with_jwt_and_postgres.repository_dao;


import static java.util.Arrays.asList;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import com.example.tdd_spring_sec_with_jwt_and_postgres.dto.UserDomainDto;
import com.example.tdd_spring_sec_with_jwt_and_postgres.repository_dao.impl.UserDomainDaoImpl;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.junit.jupiter.api.Test;

/**
 *
 */

public class RepositoryDaoTest {

    UserDomainDao userDao = mock(UserDomainDao.class);

    @Test
    public void getAllUsers() {
        UserDomainDto userDto = new UserDomainDto("Jim Carry", "jim", asList("USER", "ADMIN"));
        UserDomainDto userDto1 = new UserDomainDto("John Smith", "john",
            Collections.singletonList("USER"));
        List<UserDomainDto> dtos = new ArrayList<>();
        dtos.add(userDto);
        dtos.add(userDto1);
        when(userDao.getAllUsers()).thenReturn(dtos);

        System.out.println(userDao.getAllUsers());
    }
    @Test
    void getDto(){
        UserDomainDao dao = new UserDomainDaoImpl();
        System.out.println(dao.getAllUsers().toString());
    }
}
