package com.ty.hospitalapi.dto;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
@Entity
public class Person {
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private int id;
		private String name;
		private String emai;
		private long phone;
		private String gender;
		private String dob;
		private int age;
		
//		@ManyToOne
//		@JoinColumn
//		private Branch branch;
		
		@OneToMany(mappedBy = "person")
		private List<Encounter> encounters;
		
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getEmai() {
			return emai;
		}
		public void setEmai(String emai) {
			this.emai = emai;
		}
		public long getPhone() {
			return phone;
		}
		public void setPhone(long phone) {
			this.phone = phone;
		}
		public String getGender() {
			return gender;
		}
		public void setGender(String gender) {
			this.gender = gender;
		}
		public String getDob() {
			return dob;
		}
		public void setDob(String dob) {
			this.dob = dob;
		}
		public int getAge() {
			return age;
		}
		public void setAge(int age) {
			this.age = age;
		}


//		public Branch getBranch() {
//			return branch;
//		}
//		public void setBranch(Branch branch) {
//			this.branch = branch;
//		}
		
		
		
}
