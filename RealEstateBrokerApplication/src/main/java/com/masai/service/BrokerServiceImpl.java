
package com.masai.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.exception.AdminException;
import com.masai.exception.BrokerException;
import com.masai.exception.LoginException;
import com.masai.model.Broker;
import com.masai.model.CurrentUserSession;
import com.masai.repository.AdminRepository;
import com.masai.repository.BrokerRepository;
import com.masai.repository.SessionRepository;
@Service
public class BrokerServiceImpl implements BrokerService {
	@Autowired
   private BrokerRepository brokerRepo;
	@Autowired
	private SessionRepository sessionRepo;
	@Autowired
	private AdminRepository adminRepo;
	

	@Override
	public Broker viewBroker(Integer broId) throws BrokerException {
		Optional<Broker> broker=brokerRepo.findById(broId);
		if(broker.isPresent()) {
			return broker.get();
		}else
			throw new BrokerException("broker not found by id"+broId);
		
	}

	



	@Override
	public Broker editBroker(Broker broker, String key) throws BrokerException, LoginException {
		CurrentUserSession logInUser=sessionRepo.findByUuid(key);
		if(logInUser.equals(null))throw new AdminException("Broker not loggedIn");
		Optional<Broker> opt=brokerRepo.findById(broker.getBrokId());
		if(opt.isPresent()) {
			return brokerRepo.save(broker);
		}else {
			throw new BrokerException("broker not found ");
		}
		
		
	}




	





	@Override
	public List<Broker> viewAllBrokers() throws BrokerException {
		List<Broker> broker=brokerRepo.findAll();
		if(broker==null) throw new BrokerException("Broker is not found");
		
		return broker;
	}





	@Override
	public Broker saveBroker(Broker broker, String key) throws BrokerException, LoginException {
		CurrentUserSession logInUser=sessionRepo.findByUuid(key);
	
		if(logInUser.equals(null))
			throw new LoginException("Broker not loggedIn");
		else
			return brokerRepo.save(broker);
	}





	@Override
	public Broker removeBroker(Integer broId, String key) throws BrokerException, LoginException {
		CurrentUserSession logInUser=sessionRepo.findByUuid(key);
		if(logInUser.equals(null))throw new AdminException("Broker not loggedIn");
		Optional<Broker> opt=brokerRepo.findById(broId);
		if(opt.isPresent()) {
			Broker broker=opt.get();
			brokerRepo.delete(broker);
			return broker;
		}else {
			throw new BrokerException("Broker is not found");
		}
		
		
	}

	

	

}
