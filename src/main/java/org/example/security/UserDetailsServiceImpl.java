package org.example.security;

import lombok.RequiredArgsConstructor;
import org.example.model.User;
import org.example.model.UserRole;
import org.example.service.UserService;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserService userService;

    @Override
    public UserDetails loadUserByUsername(String login) {
        User user = userService.findByLogin(login);
        Set<GrantedAuthority> authorities = new HashSet();
        if (user.getUserRole().equals(UserRole.MAIN_ADMIN)) {
            authorities.add(new SimpleGrantedAuthority(UserRole.ADMIN.getName()));
            authorities.add(new SimpleGrantedAuthority(UserRole.MAIN_ADMIN.getName()));
        } else if (user.getUserRole().equals(UserRole.ADMIN)) {
            authorities.add(new SimpleGrantedAuthority(UserRole.ADMIN.getName()));
        }
        UserDetails userDetails =
                new org.springframework.security.core.userdetails.User(user.getLogin(),
                        user.getPassword(),
                        authorities);
        return userDetails;
    }
}
