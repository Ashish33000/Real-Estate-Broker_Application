
package com.masai.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.entity.Broker;
import com.masai.exception.BrokerException;
import com.masai.exception.LoginException;
import com.masai.repository.BrokerRepository;


@Service
public class BrokerServiceImpl implements BrokerService {
	@Autowired
	private BrokerRepository broRepo;

	@Override
	public Broker saveBroker(Broker broker) throws BrokerException {
		Broker existingBroker=broRepo.findByBrokerMobileNo(broker.getBrokerMobileNo());
		if(existingBroker!=null) {
			throw new BrokerException("Broker Already Exist with This mobile no");
		}else {
			return broRepo.save(broker);
		}
		
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
