package com.masai.service;

import java.util.List;

import com.masai.exception.BrokerException;
import com.masai.model.Broker;

public interface BrokerService {
	
	
	public Broker saveBroker(Broker broker);
	public Broker editBroker(Broker broker) throws BrokerException;
	public Broker removeBroker(int broId)throws BrokerException;
	public Broker viewBroker(int broId)throws BrokerException;
	public List<Broker> viewAllBrokers(int broId);
	

}
