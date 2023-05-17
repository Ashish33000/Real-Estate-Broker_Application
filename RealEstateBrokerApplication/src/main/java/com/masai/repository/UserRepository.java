package com.masai.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.masai.entity.Users;

public interface UserRepository extends JpaRepository<Users, Integer> {
	public Optional<Users> findByUserEmail(String email);

}
