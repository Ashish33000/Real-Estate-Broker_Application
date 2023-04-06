package com.masai.service;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.exception.LoginException;
import com.masai.model.Broker;
import com.masai.model.BrokerAdminSession;
import com.masai.model.BrokerLoginDTO;
import com.masai.repository.BrokerRepository;
import com.masai.repository.BrokerSessionRepository;

import net.bytebuddy.utility.RandomString;
@Service
public class BrokerLoginServiceImpl implements BrokerLoginService {
	@Autowired
	private BrokerRepository brokerRepo;
	@Autowired
	private BrokerSessionRepository adminsessionRepo;

	@Override
	public String logIntoAccount(BrokerLoginDTO dto) throws LoginException {
		Broker existingBroker=brokerRepo.findByBrokerMobileNo(dto.getBrokerMobileNo());
		if(existingBroker==null) {
			throw new LoginException("Please Enter a Valid Mobile no");
		}
		Optional<BrokerAdminSession> validBrokerSession=adminsessionRepo.findById(existingBroker.getBrokerId());
		if(validBrokerSession.isPresent()) {
			System.out.println(validBrokerSession);
			throw new LoginException("Admin already login with this number");
		}
		if(existingBroker.getBrokerPassword().equals(dto.getBrokerPassword())) {
			String key=RandomString.make(6);
			
			BrokerAdminSession currentusersession=new BrokerAdminSession(existingBroker.getBrokerId(),key,LocalDateTime.now());
			adminsessionRepo.save(currentusersession);
			return currentusersession.toString();
		}else {
			throw new LoginException("Admin already login with this number");
		}
		
	}

	@Override
	public String logOutAccount(String key) throws LoginException {
		BrokerAdminSession validAdminSession=adminsessionRepo.findByUuid(key);
		if(validAdminSession==null) {
			throw new LoginException("User Not logged in with this Number");
		}
		adminsessionRepo.delete(validAdminSession);
		return "Logged out";
	}

}
