package com.ty.hospitalapi.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ty.hospitalapi.dto.User;
import com.ty.hospitalapi.repository.UserRepository;

@Repository
public class UserDao {
	
	@Autowired
	UserRepository repository;
	
	public User saveUser(User user) {
		return repository.save(user);
	}
	
	public User getUserById(int id) {
		Optional<User> user=repository.findById(id);
		return user.get();
	}
	
	public List<User> getAllUsers(){
		return repository.findAll();
	}
	
	public User updateUser(User user) {
		Optional<User> user2 = repository.findById(user.getId());
		if(user2 != null) {
			return repository.save(user);
		}
		return null;
	}
	
	public boolean deleteUserById(int id) {
		Optional<User> user = repository.findById(id);
		if(user.isEmpty()) {
			return false;
		}
		else {
			repository.delete(user.get()) ;
			return true;
		}
	}
}
