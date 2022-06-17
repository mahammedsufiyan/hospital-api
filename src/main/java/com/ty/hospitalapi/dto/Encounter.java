package com.ty.hospitalapi.dto;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
@Entity
public class Encounter {
	@Id
	@GeneratedValue(strategy =  GenerationType.IDENTITY)
	private int id;
	private LocalDateTime admit_Date_Time;
	private LocalDateTime discharge_Date_Time;
	private String reason;
//	@OneToMany(mappedBy = "encounters")
//	private List<Observation> observations;
	@OneToMany(mappedBy = "encounters")
	private List<MedOrder> medOrder;
	@ManyToOne
	@JoinColumn
	private Branch branch;
	@ManyToOne
	@JoinColumn
	private Person person;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public LocalDateTime getAdmit_Date_Time() {
		return admit_Date_Time;
	}
	public void setAdmit_Date_Time(LocalDateTime admit_Date_Time) {
		this.admit_Date_Time = admit_Date_Time;
	}
	public LocalDateTime getDischarge_Date_Time() {
		return discharge_Date_Time;
	}
	public void setDischarge_Date_Time(LocalDateTime discharge_Date_Time) {
		this.discharge_Date_Time = discharge_Date_Time;
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
//	public List<Observation> getObservations() {
//		return observations;
//	}
//	public void setObservations(List<Observation> observations) {
//		this.observations = observations;
//	}
	public List<MedOrder> getMedOrder() {
		return medOrder;
	}
	public void setMedOrder(List<MedOrder> medOrder) {
		this.medOrder = medOrder;
	}
	public Branch getBranch() {
		return branch;
	}
	public void setBranch(Branch branch) {
		this.branch = branch;
	}
	public Person getPerson() {
		return person;
	}
	public void setPerson(Person person) {
		this.person = person;
	}
	
	
	
}
