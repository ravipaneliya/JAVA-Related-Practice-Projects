package com.sportyshoes.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.*;
import org.springframework.security.core.*;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import com.sportyshoes.model.User;
import com.sportyshoes.service.UserService;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

public class CustomAuthenticationProvider implements AuthenticationProvider {

	@Autowired
	UserService service;

	List<User> userList = new ArrayList<>();
	public CustomAuthenticationProvider() {
		userList.add(new User(1, "admin", "admin@test.co", "pass", true, 1000000000L));
	}

	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		String name = authentication.getName();
		String password = authentication.getCredentials().toString();
		System.out.println("Login with User (" + name + ") Pass : (" + password + ")");
		Optional<User> authenticatedUser = userList.stream()
				.filter(user -> user.getName().equals(name) && user.getPassword().equals(password)).findFirst();

		if (!authenticatedUser.isPresent()) {
			throw new BadCredentialsException("Authentication Failed..");
		}

		List<GrantedAuthority> authorities = new ArrayList<>();
		authorities.add(new SimpleGrantedAuthority(authenticatedUser.get().getIsadminAsString()));
		Authentication auth = new UsernamePasswordAuthenticationToken(name, password, authorities);
		return auth;
	}

	@Override
	public boolean supports(Class<?> aClass) {
		return aClass.equals(UsernamePasswordAuthenticationToken.class);
	}
}