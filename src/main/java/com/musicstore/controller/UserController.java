package com.musicstore.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.musicstore.model.repository.Category;
import com.musicstore.model.repository.User;
import com.musicstore.repository.UserRepository;

@RestController
@RequestMapping("/users")
//@CrossOrigin(origins = "https://musicstoreoficial.000webhostapp.com/")
@CrossOrigin(origins = "http://localhost:4200")
public class UserController {
	@Autowired
	private UserRepository repository;

	@GetMapping("/login")
	public List<User> listUser(){
		return repository.findAll();
	}
	
	@PostMapping("/login")
	public User saveUser(@RequestBody User user) {
		return repository.save(user);
	}
	
	@GetMapping("/login/{id}")
	public ResponseEntity<User> listUserById(@PathVariable Integer id){
		User user = repository.findById(id).orElse(null);
		return ResponseEntity.ok(user);
	}
	
	@PutMapping("/login/{id}")
	public ResponseEntity<User> updateUser(@PathVariable Integer id,@RequestBody User userModify){
		User user = repository.findById(id).orElse(null);
		user.setUserName(userModify.getUserName());
		user.setName(userModify.getName());
		user.setPassword(userModify.getPassword());
		user.setLastName(userModify.getLastName());
		user.setAddress(userModify.getAddress());
		user.setEmail(userModify.getEmail());
		user.setAdmin(userModify.getAdmin());
		repository.save(user);
		return ResponseEntity.ok(user);
	}
	
	@DeleteMapping("/login/{id}")
	public Integer deleteUser(@PathVariable Integer id){
		Integer number = 0;
		User user = repository.findById(id).orElse(null);
		if (user != null) {
			repository.delete(user);
			number = 1;
		}
		
		return number;
	}
}
