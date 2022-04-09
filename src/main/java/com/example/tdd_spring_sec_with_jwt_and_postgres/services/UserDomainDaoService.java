package com.example.tdd_spring_sec_with_jwt_and_postgres.services;

import com.example.tdd_spring_sec_with_jwt_and_postgres.dto.UserDomainDto;
import java.util.List;

/**
 * интерфейс предоставляет данные по пользователях для контроллера
 * The interface provides user data for the ApiController
 *
 */

public interface UserDomainDaoService {

    List<UserDomainDto> getAllUsers();
}
