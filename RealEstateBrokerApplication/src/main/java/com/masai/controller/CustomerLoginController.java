package com.masai.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.masai.exception.LoginException;
import com.masai.model.CustomerLoginDTO;
import com.masai.service.CustomerLogInService;

@RestController
public class CustomerLoginController {
	@Autowired
	private CustomerLogInService loginservice;
	@PostMapping("/userlogin")
	public ResponseEntity<String> logInHandler(@RequestBody CustomerLoginDTO dto) throws LoginException{
		return new ResponseEntity<>(loginservice.logIntoAccount(dto),HttpStatus.OK);
	}
	@PostMapping("/userlogout")
	public ResponseEntity<String> logoutInHandler(@RequestParam(required = false) String key) throws LoginException{
		return new ResponseEntity<>(loginservice.logOutAccount(key),HttpStatus.OK);
	}
	
	

}
