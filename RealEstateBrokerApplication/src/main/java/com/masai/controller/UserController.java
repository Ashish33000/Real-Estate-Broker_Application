package com.masai.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.masai.exception.UserException;
import com.masai.model.User;
import com.masai.service.UserService;

import jakarta.validation.Valid;

@RestController
public class UserController {
	@Autowired
	private UserService userservice;
	@PostMapping("/users")
	public ResponseEntity<User> saveCustomerHandler(@Valid @RequestBody User user) throws UserException{
		return new ResponseEntity<User>(userservice.createUser(user),HttpStatus.CREATED);
	}
	@PutMapping("/users")
	public ResponseEntity<User> updateCustomerHandler(@Valid @RequestBody User user,@RequestParam(required = false) String key) throws UserException{
		return new ResponseEntity<User>(userservice.updateUser(user, key),HttpStatus.CREATED);
	}

}
