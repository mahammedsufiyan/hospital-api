package com.ty.hospitalapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ty.hospitalapi.dto.Hospital;
import com.ty.hospitalapi.dto.ResponseStructure;
import com.ty.hospitalapi.services.HospitalService;

@RestController
public class HospitalController {
	
	@Autowired
	HospitalService service;
	
	@PostMapping("/hospitals")
	public ResponseStructure<Hospital> saveUser(@RequestBody Hospital hospital) {
		 return service.saveHospital(hospital);
	}
	
	@GetMapping("/hospitals/{id}")
	public ResponseStructure<Hospital> getHospitalById(@PathVariable int id) {
		return service.getHospitalById(id); 
	}
	
	@GetMapping("/hospitals")
	public ResponseStructure<List<Hospital>> getAllHospitals(){
		return service.getAllHospitals();
	}
	
	@PutMapping("/hospitals")
	public ResponseStructure<Hospital> updateUser(Hospital hospital) {
		return service.updateHospital(hospital);
	}
	
//	@DeleteMapping("/user/{id}")
//	public ResponseStructure<Hospital> deleteUser(@PathVariable int id) {
//		return service.deleteHospitalById(id);
//	}
}
