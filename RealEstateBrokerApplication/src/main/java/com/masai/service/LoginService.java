package com.masai.service;

import com.masai.exception.LoginException;
import com.masai.model.UserLoginDTO;

public interface LoginService {
	
	public String logIntoAccount(UserLoginDTO dto) throws LoginException;
	public String logOutAccount(String key) throws LoginException;
	

}
