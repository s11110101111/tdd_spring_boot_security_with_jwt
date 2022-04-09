package com.example.tdd_spring_sec_with_jwt_and_postgres.entity_domain;/*
 * Copyright (c) 2021 MTS http://mts.ru
 */

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * User domain
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDomain {
  private String name="";
  private String username="";
}
