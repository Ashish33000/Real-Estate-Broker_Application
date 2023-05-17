package com.masai.service;

import java.util.List;

import com.masai.entity.Users;
import com.masai.exception.UserException;

public interface UsersService {
	
	public Users registerUsers(Users users);
	public Users getUsersDetailsByEmail(String email) throws UserException;
	public List<Users> getAllUsersDetails()throws UserException;

}
