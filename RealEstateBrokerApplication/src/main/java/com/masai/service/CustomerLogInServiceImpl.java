package com.masai.service;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.entity.Customer;
import com.masai.entity.CustomerLoginDTO;
import com.masai.entity.CustomerSession;
import com.masai.exception.LoginException;
import com.masai.repository.CustomerRepository;
import com.masai.repository.CustomerSessionRepository;

import net.bytebuddy.utility.RandomString;
@Service
public class CustomerLogInServiceImpl implements CustomerLogInService {
	@Autowired
	private CustomerRepository  custRepo;
	@Autowired
	private CustomerSessionRepository sessionRepo;

	@Override
	public String logIntoAccount(CustomerLoginDTO dto) throws LoginException {
		Customer existingCustomer=custRepo.findByCustomerMobileNo(dto.getCustomerMobileNo());
		if(existingCustomer==null) {
			throw new LoginException("Please Enter a Valid Mobile no");
		}
		Optional<CustomerSession> validCustomerSession=sessionRepo.findById(existingCustomer.getCustId());
		if(validCustomerSession.isPresent()) {
			throw new LoginException("Customer already login with this number");
		}
		if(existingCustomer.getCustomerPassword().equals(dto.getCustomerPassword())) {
			String key=RandomString.make(6);
			
			CustomerSession currentusersession=new CustomerSession(existingCustomer.getCustId(),key,LocalDateTime.now());
			sessionRepo.save(currentusersession);
			return currentusersession.toString();
		}else
			throw new LoginException("customer already login with this number");
		
	
	}

	@Override
	public String logOutAccount(String key) throws LoginException {
		CustomerSession validUserSession=sessionRepo.findByUuid(key);
		if(validUserSession==null) {
			throw new LoginException("User Not logged in with this Number");
		}
		sessionRepo.delete(validUserSession);
		return "Logged out";
	}

}
