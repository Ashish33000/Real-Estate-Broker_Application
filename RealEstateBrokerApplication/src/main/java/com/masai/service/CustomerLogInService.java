package com.masai.service;

import com.masai.entity.CustomerLoginDTO;
import com.masai.exception.LoginException;

public interface CustomerLogInService {
	
	public String logIntoAccount(CustomerLoginDTO dto) throws LoginException;
	public String logOutAccount(String key) throws LoginException;
	

}
