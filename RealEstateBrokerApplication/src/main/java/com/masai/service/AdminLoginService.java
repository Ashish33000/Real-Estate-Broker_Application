package com.masai.service;

import com.masai.exception.LoginException;
import com.masai.model.AdminLoginDTO;

public interface AdminLoginService {
	
	public String logIntoAccount(AdminLoginDTO dto) throws LoginException;
	public String logOutAccount(String key) throws LoginException;
	

}
