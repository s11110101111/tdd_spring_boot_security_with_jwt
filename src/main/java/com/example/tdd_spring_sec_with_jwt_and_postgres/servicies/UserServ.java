package com.example.tdd_spring_sec_with_jwt_and_postgres.servicies;
/*
 * Copyright (c) 2021 MTS http://mts.ru
 */

import com.example.tdd_spring_sec_with_jwt_and_postgres.domain.User;
import java.util.List;

/**
 *
 */
public interface UserServ {
    List<User> findAllUsers();
}
