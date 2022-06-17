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

import com.ty.hospitalapi.dto.Person;
import com.ty.hospitalapi.dto.ResponseStructure;
import com.ty.hospitalapi.services.PersonService;

@RestController
public class PersonController {
	
	@Autowired
	PersonService service;
	
	@PostMapping("/persons")
	public ResponseStructure<Person> saveUser(@RequestBody Person person) {
		 return service.savePerson(person);
	}
	
	@GetMapping("/persons/{id}")
	public ResponseStructure<Person> getPersonById(@PathVariable int id) {
		return service.getPersonById(id); 
		
	}
	
	@GetMapping("/persons")
	public ResponseStructure<List<Person>> getAllPersons(){
		return service.getAllPersons();
		
	}
	
	@PutMapping("/persons")
	public ResponseStructure<Person> updatePerson(Person person) {
		return service.updatePerson(person);
	}
	
	@DeleteMapping("/person/{id}")
	public ResponseStructure<Person> deleteUser(@PathVariable int id) {
		return service.deletePerson(id);
	}
}
