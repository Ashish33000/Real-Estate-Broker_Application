package com.masai.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.masai.entity.BrokerLoginDTO;
import com.masai.exception.LoginException;
import com.masai.service.BrokerLoginService;

@RestController
@RequestMapping("/api/broker")
public class BrokerLoginController {
	@Autowired
	private BrokerLoginService loginservice;
	
	@PostMapping("/login")
	@ResponseStatus(code = HttpStatus.OK)
	public String logInHandler(@RequestBody BrokerLoginDTO dto) {
		return loginservice.logIntoAccount(dto);
	}
	@PostMapping("/logout")
	@ResponseStatus(code = HttpStatus.OK)
	public String logoutInHandler(@RequestParam(required = false) String key) {
		return loginservice.logOutAccount(key);
	}
	
	

}
