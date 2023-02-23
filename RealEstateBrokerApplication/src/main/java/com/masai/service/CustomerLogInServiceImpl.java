package com.masai.service;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.exception.LoginException;
import com.masai.model.CurrentUserSession;
import com.masai.model.Customer;
import com.masai.model.LoginDTO;
import com.masai.repository.CustomerRepository;
import com.masai.repository.SessionRepository;

import net.bytebuddy.utility.RandomString;
@Service
public class CustomerLogInServiceImpl implements LoginService {
	@Autowired
	private CustomerRepository  customerRepo;
	@Autowired
	private SessionRepository sessionRepo;

	@Override
	public String logIntoAccount(LoginDTO dto) throws LoginException {
		Customer existiongCustomer=customerRepo.findByCustomerMobileNo(dto.getMobileNo());
		if(existiongCustomer==null) {
			throw new LoginException("Please Enter a Valid Mobile no");
		}
		Optional<CurrentUserSession> validCustomerSession=sessionRepo.findById(existiongCustomer.getCustomerId());
		if(validCustomerSession.isPresent()) {
			throw new LoginException("User already login with this number");
		}
		if(existiongCustomer.getCustomerPassword().equals(dto.getPassword())) {
			String key=RandomString.make(6);
			
			CurrentUserSession currentusersession=new CurrentUserSession(existiongCustomer.getCustomerId(),key,LocalDateTime.now());
			sessionRepo.save(currentusersession);
			return currentusersession.toString();
		}else
			throw new LoginException("User already login with this number");
	
	}

	@Override
	public String logOutAccount(String key) throws LoginException {
		CurrentUserSession validCustomerSession=sessionRepo.findByUuid(key);
		if(validCustomerSession==null) {
			throw new LoginException("User Not logged in with this Number");
		}
		sessionRepo.delete(validCustomerSession);
		return "Logged out";
	}

}
