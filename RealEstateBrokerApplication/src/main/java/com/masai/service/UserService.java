package com.masai.service;

import com.masai.exception.UserException;
import com.masai.model.User;

public interface UserService {
	
	public User createUser(User user) throws UserException;
	public User updateUser(User customer,String key)throws UserException;

}
