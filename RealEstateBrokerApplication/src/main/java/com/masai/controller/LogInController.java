package com.masai.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.masai.entity.Users;
import com.masai.repository.UserRepository;

@RestController
public class LogInController {
	@Autowired
	private UserRepository userRepo;
	@GetMapping("/signIn")
	@ResponseStatus(code=HttpStatus.OK)
	public Users getLoggedInUsersHandler(Authentication auth) {
		System.out.println(auth);
		Users user=userRepo.findByUserEmail(auth.getName()).orElseThrow(()->new BadCredentialsException("Invalid Username and Password"));
		return user;
	}

}
