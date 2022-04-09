package com.example.tdd_spring_sec_with_jwt_and_postgres.repository_dao;

import com.example.tdd_spring_sec_with_jwt_and_postgres.entity_domain.UserDomain;
import java.util.List;

/**
 *
 */

public interface UserDomainDao {
           List<UserDomain> getAllUsers();

}
