
package com.masai.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.entity.Broker;
import com.masai.entity.BrokerSession;
import com.masai.exception.BrokerException;
import com.masai.exception.LoginException;
import com.masai.repository.BrokerRepository;
import com.masai.repository.BrokerSessionRepository;


@Service
public class BrokerServiceImpl implements BrokerService {
	@Autowired
	private BrokerRepository broRepo;
	@Autowired
	private BrokerSessionRepository sessionRepo;

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
	public Broker editBroker(Broker broker,  String key) throws BrokerException, LoginException {
		BrokerSession validSession=sessionRepo.findByUuid(key);
		if(validSession==null)throw new LoginException("Broker Not Logged In LogIn first");
		Optional<Broker> opt=broRepo.findById(broker.getBrokerId());
		if(opt.isEmpty()) {
			throw new BrokerException("No Broker Exist with this Given Id: "+broker.getBrokerId());
		}else {
			 broker=opt.get();
			broRepo.save(broker);
			return broker;
		}
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
