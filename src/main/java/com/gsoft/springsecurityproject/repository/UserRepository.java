package com.gsoft.springsecurityproject.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import com.gsoft.springsecurityproject.entity.User;
@Component
public interface UserRepository extends JpaRepository<User, Integer> {

	Optional<User> findByUsername(String username);

	Optional<User> findByUsernameAndPassword(String username, String password);
	
}
