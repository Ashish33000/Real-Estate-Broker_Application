
package com.masai.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.exception.BrokerException;
import com.masai.model.Broker;
import com.masai.repo.BrokerRepository;


@Service
public class BrokerServiceImpl implements BrokerService {
	@Autowired
	private BrokerRepository brokerRepo;

	@Override
	public Broker saveBroker(Broker broker) throws BrokerException {
		// TODO Auto-generated method stub
		return brokerRepo.save(broker);
	}

	@Override
	public Broker editBroker(Integer broId,Broker broker) throws BrokerException {
		Optional<Broker> opt=brokerRepo.findById(broId);
		if(opt.isEmpty()) {
			throw new BrokerException("No broker Exist from this brokerId: "+broId);
		}else {
			Broker broker1=opt.get();
			broker1.setName(broker.getName());
			 brokerRepo.save(broker1);
			 return broker1;
		}
		
	}

	@Override
	public Broker removeBroker(Integer broId) throws BrokerException {
		Optional<Broker> opt=brokerRepo.findById(broId);
		if(opt.isEmpty()) {
			throw new BrokerException("No broker Exist from this brokerId: "+broId);
		}else {
			Broker broker=opt.get();
			
			brokerRepo.delete(broker);
			return broker;
		}
		
		
	}

	@Override
	public Broker viewBroker(Integer broId) throws BrokerException {
		// TODO Auto-generated method stub
		return brokerRepo.findById(broId).orElseThrow(()->new BrokerException("No broker Found"));
	}

	@Override
	public List<Broker> viewAllBrokers() throws BrokerException {
		List<Broker> list=brokerRepo.findAll();
		if(list.isEmpty())new BrokerException("No broker Found");
		return list;
	}


	






	
	

	

	

}
