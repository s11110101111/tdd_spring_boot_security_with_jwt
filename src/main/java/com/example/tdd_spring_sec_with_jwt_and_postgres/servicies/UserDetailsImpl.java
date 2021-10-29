package com.example.tdd_spring_sec_with_jwt_and_postgres.servicies;/*
 * Copyright (c) 2021 MTS http://mts.ru
 */

import com.example.tdd_spring_sec_with_jwt_and_postgres.domain.User;
import java.util.Collection;
import java.util.List;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

/**
 *
 */
public class UserDetailsImpl implements UserServ{

    @Override
    public List<User> findAllUsers() {
        return null;
    }

    public final static class UserServiceDetails extends User implements UserDetails {

        public UserServiceDetails(User user) {
            super(user);
        }

        @Override
        public Collection<? extends GrantedAuthority> getAuthorities() {
            List<GrantedAuthority> roles = AuthorityUtils.createAuthorityList("ROLE_USER");
            if (this.isAdmin()) {
                roles.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
            }
            return roles;
        }

        @Override
        public boolean isAccountNonExpired() {
            return true;
        }

        @Override
        public boolean isAccountNonLocked() {
            return true;
        }

        @Override
        public boolean isCredentialsNonExpired() {
            return true;
        }
    }



}
