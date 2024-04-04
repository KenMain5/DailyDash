package com.DailyDash.AccountManagement.security;


import com.DailyDash.AccountManagement.entity.DashUser;
import com.DailyDash.AccountManagement.entity.Role;
import com.DailyDash.AccountManagement.repository.DashUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Collections;

@Service
public class CustomUserDetailsService  implements UserDetailsService {

    private final DashUserRepository dashUserRepository;

    @Autowired
    public CustomUserDetailsService(DashUserRepository dashUserRepository) {
        this.dashUserRepository = dashUserRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        DashUser optionalUser = dashUserRepository
                .findDashUserByEmail(username)
                .orElseThrow(() -> new UsernameNotFoundException("Username is not found"));
        return new User(optionalUser.getEmail(), optionalUser.getPassword(), getGrantedAuthority(optionalUser.getRole()));
    }

    private Collection<GrantedAuthority> getGrantedAuthority(Role role){
        return Collections.singletonList(new SimpleGrantedAuthority(role.getName()));
    }
}
