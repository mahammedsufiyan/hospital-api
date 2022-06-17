package com.ty.hospitalapi.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.ty.hospitalapi.dao.HospitalDao;
import com.ty.hospitalapi.dto.Branch;
import com.ty.hospitalapi.dto.Hospital;
import com.ty.hospitalapi.dto.ResponseStructure;

@Service
public class HospitalService {
	
	@Autowired
	HospitalDao dao;
	
	public ResponseStructure<Hospital> saveHospital(Hospital hospital){
		
		ResponseStructure<Hospital> responseStructure = new ResponseStructure<Hospital>();
		responseStructure.setStatusCode(HttpStatus.CREATED.value());
		responseStructure.setMessage("Created");
		
		List<Branch> branchs = hospital.getBranchs();
		for(Branch branch:branchs) {
			branch.setHospital(hospital);
		}
		responseStructure.setData(hospital);
		return responseStructure;
	}
	
	public ResponseStructure<Hospital> getHospitalById(int id){
		ResponseStructure<Hospital> responseStructure = new ResponseStructure<Hospital>();
		Hospital hospital = dao.getHospitalById(id);
		if(hospital != null) {
			responseStructure.setStatusCode(HttpStatus.OK.value());
			responseStructure.setMessage("Ok data is here");
			responseStructure.setData(hospital);
		}else {
			responseStructure.setStatusCode(HttpStatus.OK.value());
			responseStructure.setMessage("No data find with this id");
			responseStructure.setData(hospital);
		}
		return responseStructure;
	}
	
	public ResponseStructure<List<Hospital>> getAllHospitals(){
		ResponseStructure<List<Hospital>> responseStructure = new ResponseStructure<List<Hospital>>();
		responseStructure.setStatusCode(HttpStatus.OK.value());
		responseStructure.setMessage("All data here");
		responseStructure.setData(dao.getAllHospitals());
		return responseStructure;
	}
	
public ResponseStructure<Hospital> updateHospital(Hospital hospital){
		
		ResponseStructure<Hospital> responseStructure = new ResponseStructure<Hospital>();
		responseStructure.setStatusCode(HttpStatus.CREATED.value());
		responseStructure.setMessage("Created");
		
		List<Branch> branchs = hospital.getBranchs();
		for(Branch branch:branchs) {
			branch.setHospital(hospital);
		}
		responseStructure.setData(hospital);
		return responseStructure;
	}
}
