package com.masai.service;

import com.masai.exception.LoginException;
import com.masai.model.BrokerLoginDTO;

public interface BrokerLoginService {
	
	public String logIntoAccount(BrokerLoginDTO dto) throws LoginException;
	public String logOutAccount(String key) throws LoginException;
	

}
