package com.ty.hospitalapi.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.ty.hospitalapi.dao.PersonDao;
import com.ty.hospitalapi.dto.Person;
import com.ty.hospitalapi.dto.ResponseStructure;

@Service
public class PersonService {
	
	@Autowired
	PersonDao dao;
	
	public ResponseStructure<Person> savePerson(Person person){
		ResponseStructure<Person> responseStructure = new ResponseStructure<Person>();
		responseStructure.setStatusCode(HttpStatus.CREATED.value());
		responseStructure.setMessage("Person Created");
		responseStructure.setData(person);
		return responseStructure;
	}
	
	public ResponseStructure<Person> getPersonById(int id){
		ResponseStructure<Person> responseStructure = new ResponseStructure<Person>();
		Person person = dao.getPersonById(id);
		if(person != null) {
			responseStructure.setStatusCode(HttpStatus.OK.value());
			responseStructure.setMessage("ok");
			responseStructure.setData(person);
		}else {
			responseStructure.setStatusCode(HttpStatus.NOT_FOUND.value());
			responseStructure.setMessage("Data not found");
			responseStructure.setData(person);
		}
		return responseStructure;
	}
	
	public ResponseStructure<List<Person>> getAllPersons(){
		ResponseStructure<List<Person>> responseStructure = new ResponseStructure<List<Person>>();
		responseStructure.setStatusCode(HttpStatus.OK.value());
		responseStructure.setMessage("Succsess");
		responseStructure.setData(dao.getAllPersons());

		return responseStructure;
	}
	
	public ResponseStructure<Person> updatePerson(Person person) {

		ResponseStructure<Person> responseStructure = new ResponseStructure<Person>();
		if(dao.updatePerson(person) != null) {
			responseStructure.setStatusCode(HttpStatus.CREATED.value());
			responseStructure.setMessage("Succsess");
			responseStructure.setData(dao.updatePerson(person));
		}
		else {
			responseStructure.setStatusCode(HttpStatus.NOT_FOUND.value());
			responseStructure.setMessage("Not updated");
			responseStructure.setData(dao.updatePerson(person));
		}
		return responseStructure;
	}

	public ResponseStructure<Person> deletePerson(int id) {

		ResponseStructure<Person> responseStructure = new ResponseStructure<Person>();
		if (dao.deletePerson(id)) {
			responseStructure.setStatusCode(HttpStatus.OK.value());
			responseStructure.setMessage("Ok");
		} else {
			responseStructure.setStatusCode(HttpStatus.NOT_FOUND.value());
			responseStructure.setMessage("Cant delete due to no data");
		}
		return responseStructure;
	}
}
