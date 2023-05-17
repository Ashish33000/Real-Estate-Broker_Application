package com.masai.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.masai.entity.Users;
import com.masai.repository.UserRepository;
import com.masai.service.UsersService;

@RestController
public class UserController {
	@Autowired
	private UsersService userSer;
	@Autowired
	private PasswordEncoder ps;
	@Autowired
	private UserRepository userRepo;
	
	@PostMapping("/users")
	@ResponseStatus(code=HttpStatus.CREATED)
	public Users saveUserHandler(@RequestBody Users users) {
		users.setUserPassword(ps.encode(users.getUserPassword()));
		return userSer.registerUsers(users);
	}
	@GetMapping("/users/{email}")
	@ResponseStatus(code=HttpStatus.OK)
	public Users getCustomerByEmail(@PathVariable String email) {
		return userSer.getUsersDetailsByEmail(email);
	}
	@GetMapping("/users")
	@ResponseStatus(code=HttpStatus.OK)
	public List<Users> getAllUsersHandler(){
		return userSer.getAllUsersDetails();
	}
	@GetMapping("/signIn")
	@ResponseStatus(code=HttpStatus.OK)
	public Users getLoggedInUsersHandler(Authentication auth) {
		System.out.println(auth);
		Users user=userRepo.findByUserEmail(auth.getName()).orElseThrow(()->new BadCredentialsException("Invalid Username and Password"));
		return user;
	}
	

}
