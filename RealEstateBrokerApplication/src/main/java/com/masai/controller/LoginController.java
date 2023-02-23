package com.masai.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.masai.exception.LoginException;
import com.masai.model.LoginDTO;
import com.masai.service.LoginService;

@RestController
public class LoginController {
	@Autowired
	private LoginService loginservice;
	@PostMapping("/login")
	public ResponseEntity<String> logInHandler(@RequestBody LoginDTO dto) throws LoginException{
		return new ResponseEntity<>(loginservice.logIntoAccount(dto),HttpStatus.OK);
	}
	@PostMapping("/logout")
	public ResponseEntity<String> logoutInHandler(@RequestParam(required = false) String key) throws LoginException{
		return new ResponseEntity<>(loginservice.logOutAccount(key),HttpStatus.OK);
	}
	
	

}
