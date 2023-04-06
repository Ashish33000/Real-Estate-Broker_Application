package com.masai.service;

import java.util.List;

import com.masai.exception.BrokerException;
import com.masai.exception.LoginException;
import com.masai.model.Broker;

public interface BrokerService {
	
	
	public Broker saveBroker(Broker broker,String key)throws BrokerException,LoginException;
	public Broker editBroker(Broker broker,String key) throws BrokerException,LoginException;
	public Broker removeBroker(Integer broId,String key)throws BrokerException,LoginException;
	public Broker viewBroker(Integer broId)throws BrokerException;
	public List<Broker> viewAllBrokers()throws BrokerException;
	

}
