package com.security.demo;

import org.springframework.security.authentication.*;
import org.springframework.security.core.*;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import com.security.entity.User;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CustomAuthenticationProvider implements AuthenticationProvider {
	
    List<User> demoUsers = new ArrayList<>();

    public CustomAuthenticationProvider() {
        demoUsers.add(new User("ravi", "upass", "ROLE_USER"));
        demoUsers.add(new User("admin", "apass", "ROLE_ADMIN"));
    }

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String name = authentication.getName();
        String password = authentication.getCredentials().toString();

        //jdk 8 -- stream
        Optional<User> authenticatedUser = demoUsers.stream().filter(
                user -> user.getName().equals(name) && user.getPassword().equals(password)
        ).findFirst();

        if(!authenticatedUser.isPresent()){
            throw new BadCredentialsException("Some Text");
        }

        List<GrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority(authenticatedUser.get().getRole()));
        Authentication auth = new UsernamePasswordAuthenticationToken(name, password, authorities);
        return auth;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return aClass.equals(UsernamePasswordAuthenticationToken.class);
    }
}