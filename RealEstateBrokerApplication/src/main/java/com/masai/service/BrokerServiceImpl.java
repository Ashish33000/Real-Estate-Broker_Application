
package com.masai.service;

import java.util.List;
import java.util.Optional;

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
	public Broker saveBroker(Broker broker) throws BrokerException {
		Broker existingBroker=brokerRepo.findByBroName(broker.getBroName());
		if(existingBroker!=null) {
			throw new BrokerException("broker Already exist");
		}else
			broker=brokerRepo.save(broker);
		return broker;
	}

	@Override
	public Broker editBroker(Broker broker) throws BrokerException {
		// TODO Auto-generated method stub
		if(broker!=null) {
			return brokerRepo.save(broker);
		}else
			throw new BrokerException("broker not found");
		
	}

	

	@Override
	public Broker viewBroker(Integer broId) throws BrokerException {
		Optional<Broker> broker=brokerRepo.findById(broId);
		if(broker.isPresent()) {
			return broker.get();
		}else
			throw new BrokerException("broker not found by id"+broId);
		
	}

	@Override
	public List<Broker> viewAllBrokers() {
		List<Broker> broker=brokerRepo.findAll();
		
		return broker;
	}

	@Override
	public Broker removeBroker(Integer broId) throws BrokerException {
		Optional<Broker> broker=brokerRepo.findById(broId);
		if(broker.isEmpty())
			throw new BrokerException("broker not found by id"+broId);
		brokerRepo.delete(broker.get());
		return broker.get();
	}

	

}
