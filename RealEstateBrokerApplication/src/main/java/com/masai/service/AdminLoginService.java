package com.masai.service;

import com.masai.exception.LoginException;
import com.masai.model.LoginDTO;

public interface AdminLoginService {
	
	public String logIntoAccount(LoginDTO dto) throws LoginException;
	public String logOutAccount(String key) throws LoginException;
	

}
