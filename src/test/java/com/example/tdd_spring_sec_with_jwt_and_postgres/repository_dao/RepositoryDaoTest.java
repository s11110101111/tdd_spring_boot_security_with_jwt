package com.example.tdd_spring_sec_with_jwt_and_postgres.repository_dao;


import static java.util.Arrays.asList;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import com.example.tdd_spring_sec_with_jwt_and_postgres.entity_domain.UserDomain;
import com.example.tdd_spring_sec_with_jwt_and_postgres.repository_dao.impl.UserDomainDaoImpl;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.junit.jupiter.api.Test;

/**
 *проверка интерфейса получения данных
 * data fetch interface check
 */

public class RepositoryDaoTest {

    UserDomainDao userDao = mock(UserDomainDao.class);

    @Test
    public void getAllUsers() {
        UserDomain user = new UserDomain("Jim Carry", "jim", asList("USER", "ADMIN"));
        UserDomain user1 = new UserDomain("John Smith", "john",
            Collections.singletonList("USER"));
        List<UserDomain> users = new ArrayList<>();
        users.add(user);
        users.add(user1);
        when(userDao.getAllUsers()).thenReturn(users);

        System.out.println(userDao.getAllUsers());
    }
    @Test
    void getDto(){
        UserDomainDao dao = new UserDomainDaoImpl();
        assertThat(dao.getAllUsers().get(0).getUsername()).isEqualTo("jim");
    }
}
