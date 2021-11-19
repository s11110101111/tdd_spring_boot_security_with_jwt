package com.example.tdd_spring_sec_with_jwt_and_postgres.services.impl;

import com.example.tdd_spring_sec_with_jwt_and_postgres.dto.UserDomainDto;
import com.example.tdd_spring_sec_with_jwt_and_postgres.repository_dao.UserDomainDao;
import com.example.tdd_spring_sec_with_jwt_and_postgres.services.UserDomainDaoService;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 */
@Service
public class UserDomainDaoServiceImpl implements UserDomainDaoService {

    private final UserDomainDao userDomainDao;

    public UserDomainDaoServiceImpl(@Autowired
        UserDomainDao userDomainDao) {
        this.userDomainDao = userDomainDao;
    }

    @Override
    public List<UserDomainDto> getAllUsers() {
        List<UserDomainDto> userDtos = userDomainDao.getAllUsers().stream()
            .map(userDomain -> {
               return new UserDomainDto(userDomain.getName(),userDomain.getUsername(), userDomain.getRoles());
            }).collect(Collectors.toList());
         return userDtos;
    }
}
