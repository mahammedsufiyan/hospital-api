package com.ty.hospitalapi.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.ty.hospitalapi.dao.UserDao;
import com.ty.hospitalapi.dto.ResponseStructure;
import com.ty.hospitalapi.dto.User;

@Service
public class UserService {
	@Autowired
	UserDao dao;

	public ResponseStructure<User> saveUser(User user) {

		ResponseStructure<User> responseStructure = new ResponseStructure<User>();
		responseStructure.setStatusCode(HttpStatus.CREATED.value());
		responseStructure.setMessage("Succsuss");
		responseStructure.setData(dao.saveUser(user));

		return responseStructure;
	}

	public ResponseStructure<User> getUserById(int id) {

		ResponseStructure<User> responseStructure = new ResponseStructure<User>();
		User user = dao.getUserById(id);
		if(user != null) {
			responseStructure.setStatusCode(HttpStatus.CREATED.value());
			responseStructure.setMessage("Succsess");
			responseStructure.setData(user);
		}
		else {
			responseStructure.setStatusCode(HttpStatus.NOT_FOUND.value());
			responseStructure.setMessage("Not updated");
			responseStructure.setData(user);
		}
		return responseStructure;
	}

	public ResponseStructure<List<User>> getAllUsers() {

		ResponseStructure<List<User>> responseStructure = new ResponseStructure<List<User>>();
		responseStructure.setStatusCode(HttpStatus.OK.value());
		responseStructure.setMessage("Succsess");
		responseStructure.setData(dao.getAllUsers());

		return responseStructure;
	}

	public ResponseStructure<User> updateUser(User user) {

		ResponseStructure<User> responseStructure = new ResponseStructure<User>();
		if(dao.updateUser(user) != null) {
			responseStructure.setStatusCode(HttpStatus.CREATED.value());
			responseStructure.setMessage("Succsess");
			responseStructure.setData(dao.updateUser(user));
		}
		else {
			responseStructure.setStatusCode(HttpStatus.NOT_FOUND.value());
			responseStructure.setMessage("Not updated");
			responseStructure.setData(dao.updateUser(user));
		}
		return responseStructure;
	}

	public ResponseStructure<User> deleteUserById(int id) {

		ResponseStructure<User> responseStructure = new ResponseStructure<User>();
		if (dao.deleteUserById(id)) {
			responseStructure.setStatusCode(HttpStatus.OK.value());
			responseStructure.setMessage("Ok");
		} else {
			responseStructure.setStatusCode(HttpStatus.NOT_FOUND.value());
			responseStructure.setMessage("Cant delete due to no data");
		}
		return responseStructure;
	}
}
