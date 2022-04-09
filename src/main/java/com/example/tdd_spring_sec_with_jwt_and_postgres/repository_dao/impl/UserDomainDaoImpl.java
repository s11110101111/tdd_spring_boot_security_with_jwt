package com.example.tdd_spring_sec_with_jwt_and_postgres.repository_dao.impl;

import static java.util.Arrays.asList;

import com.example.tdd_spring_sec_with_jwt_and_postgres.entity_domain.UserDomain;
import com.example.tdd_spring_sec_with_jwt_and_postgres.repository_dao.UserDomainDao;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 *
 */
@Service
public class UserDomainDaoImpl implements UserDomainDao {
    private List<UserDomain> userDomains = new ArrayList<>();
    {
        userDomains.add(new UserDomain("Jim Carry", "jim", asList("USER", "ADMIN")));
        userDomains.add(new UserDomain("John Smith", "john", Collections.singletonList("USER")));
    }

    @Override
    public List<UserDomain> getAllUsers() {
        return userDomains;
    }
}
