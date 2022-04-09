package com.example.tdd_spring_sec_with_jwt_and_postgres.services;

import static java.util.Arrays.asList;
import static org.assertj.core.api.Assertions.assertThat;

import com.example.tdd_spring_sec_with_jwt_and_postgres.entity_domain.UserDomain;
import com.example.tdd_spring_sec_with_jwt_and_postgres.services.UserDomainService.UserDomainDetails;
import java.util.Set;
import org.junit.jupiter.api.Test;
import org.springframework.security.core.authority.AuthorityUtils;

/**
 * User Domain Test
 */

class UserDomainServiceTest {
@Test
    public void userGetRoleUserDefault(){
    UserDomain user = new UserDomain("Jim Carry","jim");
    UserDomainService.UserDomainDetails userDomainDetails = new UserDomainDetails(user);
    Set<String> authorities = AuthorityUtils.authorityListToSet(userDomainDetails.getAuthorities());
    assertThat(authorities).contains("ROLE_USER");

}
@Test
    public void userGetRoleAdminIfSet(){
    UserDomain user = new UserDomain("Jim Carry","jim",asList("USER","ADMIN"));
    UserDomainService.UserDomainDetails userDomainDetails = new UserDomainDetails(user);
    Set<String> authorities = AuthorityUtils.authorityListToSet(userDomainDetails.getAuthorities());
    assertThat(authorities).contains("ROLE_ADMIN");
}
@Test
    public void userDetailsHasSameValuesAsUserDomain(){
    UserDomain user = new UserDomain("Jim Carry","jim",asList("USER","ADMIN"));
    user.setPassword("123");
    UserDomainService.UserDomainDetails userDomainDetails = new UserDomainDetails(user);
    assertThat(userDomainDetails.getName()).isEqualTo("Jim Carry");
    assertThat(userDomainDetails.getUsername()).isEqualTo("jim");
    assertThat(userDomainDetails.getPassword()).isEqualTo("123");
}

}