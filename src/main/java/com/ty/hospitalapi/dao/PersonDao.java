package com.ty.hospitalapi.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ty.hospitalapi.dto.Person;
import com.ty.hospitalapi.repository.PersonRepository;

@Repository
public class PersonDao {
	
	@Autowired
	PersonRepository personRepository;
	
	public Person savePerson(Person person) {
		return personRepository.save(person);
	}
	
	public Person getPersonById(int id) {
		Optional<Person> optional = personRepository.findById(id);
		if(optional.isEmpty()) {
			return null;
		}
		else {
			return optional.get();
		}
	}
	
	public List<Person> getAllPersons(){
		return personRepository.findAll();
	}
	
	public Person updatePerson(Person person) {
		Optional<Person> person1 = personRepository.findById(person.getId());
		if(person1.isEmpty()) {
			return personRepository.save(person1.get());
		}
		return null;
	}
	
	public boolean deletePerson(int id) {
		Optional<Person> person = personRepository.findById(id);
		if(person.isEmpty()) {
			personRepository.delete(person.get());
			return true;
		}
		return false;
	}
}
