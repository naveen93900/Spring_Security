package com.gsoft.springsecurityproject.config;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.gsoft.springsecurityproject.entity.User;
import com.gsoft.springsecurityproject.repository.UserRepository;

@Component
public class UserUserDetailsService implements UserDetailsService {

	@Autowired
	UserRepository repository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<User> u = repository.findByUsername(username);
		return u.map(UserUserDetails::new).orElseThrow(()->new UsernameNotFoundException("Unable To Find Username"));
	}

}
