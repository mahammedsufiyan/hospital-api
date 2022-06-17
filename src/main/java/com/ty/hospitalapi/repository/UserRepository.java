package com.ty.hospitalapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ty.hospitalapi.dto.User;

public interface UserRepository extends JpaRepository<User, Integer> {

}
