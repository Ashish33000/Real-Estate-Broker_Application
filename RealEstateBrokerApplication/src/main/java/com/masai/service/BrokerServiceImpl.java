
package com.masai.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.masai.exception.BrokerException;
import com.masai.exception.LoginException;
import com.masai.model.Broker;
@Service
public class BrokerServiceImpl implements BrokerService {

	@Override
	public Broker saveBroker(Broker broker, String key) throws BrokerException, LoginException {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Broker editBroker(Broker broker, String key) throws BrokerException, LoginException {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Broker removeBroker(Integer broId, String key) throws BrokerException, LoginException {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Broker viewBroker(Integer broId) throws BrokerException {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public List<Broker> viewAllBrokers() throws BrokerException {
		// TODO Auto-generated method stub
		return null;
	}

	
	

	

	

}
