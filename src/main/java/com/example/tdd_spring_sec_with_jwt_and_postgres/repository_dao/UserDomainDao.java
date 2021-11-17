package com.example.tdd_spring_sec_with_jwt_and_postgres.repository_dao;

import com.example.tdd_spring_sec_with_jwt_and_postgres.dto.UserDomainDto;
import java.util.List;

/**
 *
 */

public interface UserDomainDao {
           List<UserDomainDto> getAllUsers();

}
