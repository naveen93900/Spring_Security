package com.gsoft.springsecurityproject.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.gsoft.springsecurityproject.dto.UserLogin;
import com.gsoft.springsecurityproject.entity.User;
import com.gsoft.springsecurityproject.repository.UserRepository;

@RestController
public class UserController {

	@Autowired
	UserRepository repository;
	
	@Autowired
	PasswordEncoder encoder;

	@GetMapping("/hi")
	public String hello() {
		return "Hello From User Controller...";
	}

	@PostMapping("/save")
	public User saveUser(@RequestBody User user) {
		user.setPassword(encoder.encode(user.getPassword()));
		return repository.save(user);
	}

	@PutMapping("/update")
	public User updateUser(@RequestBody User user) {
		return repository.save(user);
	}

	@PreAuthorize("hasAuthority('ADMIN')")
	@GetMapping(value = "/delete/{id}")
	public String deleteUserById(@PathVariable int id) {
		if(repository.findById(id).isEmpty())
			return "Invalid User ID...";
		repository.deleteById(id);
		return "User Deleted Successfully...";
	}
	
	@PreAuthorize("hasAuthority('USER')")
	@GetMapping(value = "/find/{id}")
	public User findUserById(@PathVariable int id) {
		Optional<User> u = repository.findById(id);
		if (u.isEmpty())
			return null;
		return u.get();
	}
	
	
	@PreAuthorize("hasAuthority('ADMIN')")
	@GetMapping("/findall")
	public List<User> findAllUsers(){
		return repository.findAll();
	}
	
	@PostMapping(value = "/login")
	public User login(@RequestBody UserLogin userLogin) {
		Optional<User> u = repository.findByUsernameAndPassword(userLogin.getUsername(), userLogin.getPassword());
		if(u.isEmpty())
			return null;
		return u.get();
	}

}








