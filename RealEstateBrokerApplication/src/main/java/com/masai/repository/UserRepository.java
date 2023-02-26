package com.masai.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.masai.model.User;

public interface UserRepository extends JpaRepository<User, Integer> {
	
	public User findByUserMobileno(String usermobileNo);

}
