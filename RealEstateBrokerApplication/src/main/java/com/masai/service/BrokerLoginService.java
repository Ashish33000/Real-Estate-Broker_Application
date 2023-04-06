package com.masai.service;

import com.masai.entity.BrokerLoginDTO;
import com.masai.exception.LoginException;

public interface BrokerLoginService {
	
	public String logIntoAccount(BrokerLoginDTO dto) throws LoginException;
	public String logOutAccount(String key) throws LoginException;
	

}
