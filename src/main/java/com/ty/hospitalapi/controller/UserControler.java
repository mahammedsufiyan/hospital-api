package com.ty.hospitalapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ty.hospitalapi.dto.ResponseStructure;
import com.ty.hospitalapi.dto.User;
import com.ty.hospitalapi.services.UserService;

@RestController
public class UserControler {
	
	@Autowired
	UserService service;
	
	@PostMapping("/users")
	public ResponseStructure<User> saveUser(@RequestBody User user) {
		 return service.saveUser(user);
	}
	
	@GetMapping("/users/{id}")
	public ResponseStructure<User> getUserById(@PathVariable int id) {
		return service.getUserById(id); 
		
	}
	
	@GetMapping("/users")
	public ResponseStructure<List<User>> getAllUsers(){
		return service.getAllUsers();
		
	}
	
	@PutMapping("/users")
	public ResponseStructure<User> updateUser(User user) {
		return service.updateUser(user);
	}
	
	@DeleteMapping("/user/{id}")
	public ResponseStructure<User> deleteUser(@PathVariable int id) {
		return service.deleteUserById(id);
	}
}
