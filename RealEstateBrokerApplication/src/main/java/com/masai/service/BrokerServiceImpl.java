package com.masai.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.exception.BrokerException;
import com.masai.model.Broker;
import com.masai.repository.BrokerRepository;
@Service
public class BrokerServiceImpl implements BrokerService {
	@Autowired
   private BrokerRepository brokerRepo;
	@Override
	public Broker saveBroker(Broker broker) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Broker editBroker(Broker broker) throws BrokerException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Broker removeBroker(int broId) throws BrokerException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Broker viewBroker(int broId) throws BrokerException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Broker> viewAllBrokers(int broId) {
		// TODO Auto-generated method stub
		return null;
	}

}
