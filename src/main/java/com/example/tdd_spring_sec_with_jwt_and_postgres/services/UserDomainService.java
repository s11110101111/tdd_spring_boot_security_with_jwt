package com.example.tdd_spring_sec_with_jwt_and_postgres.services;

import com.example.tdd_spring_sec_with_jwt_and_postgres.entity_domain.UserDomain;
import java.util.Collection;
import java.util.List;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

/**
 * Service user domain
 * provides data for authorized users
 */

public class UserDomainService {

    public final static class UserDomainDetails extends UserDomain implements UserDetails {

        public UserDomainDetails(UserDomain user) {
            super(user);
        }

        @Override
        public Collection<? extends GrantedAuthority> getAuthorities() {
            List<GrantedAuthority> roles = AuthorityUtils.createAuthorityList("ROLE_USER");
            if (this.getRoles().contains("ADMIN")) {
                roles.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
            }
            return roles;
        }

        @Override
        public String getPassword() {
            return super.getPassword();
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

        @Override
        public boolean isEnabled() {
            return true;
        }
    }

}
