package com.masai.service;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.exception.LoginException;
import com.masai.model.CustomerUserSession;
import com.masai.model.User;
import com.masai.model.UserLoginDTO;
import com.masai.repository.CustomerSessionRepository;
import com.masai.repository.UserRepository;

import net.bytebuddy.utility.RandomString;
@Service
public class UserLogInServiceImpl implements LoginService {
	@Autowired
	private UserRepository  userRepo;
	@Autowired
	private CustomerSessionRepository sessionRepo;

	@Override
	public String logIntoAccount(UserLoginDTO dto) throws LoginException {
		User existiongUser=userRepo.findByUserMobileno(dto.getUsermobileNo());
		if(existiongUser==null) {
			throw new LoginException("Please Enter a Valid Mobile no");
		}
		Optional<CustomerUserSession> validCustomerSession=sessionRepo.findById(existiongUser.getUserId());
		if(validCustomerSession.isPresent()) {
			throw new LoginException("User already login with this number");
		}
		if(existiongUser.getUserPassword().equals(dto.getUserpassword())) {
			String key=RandomString.make(6);
			
			CustomerUserSession currentusersession=new CustomerUserSession(existiongUser.getUserId(),key,LocalDateTime.now());
			sessionRepo.save(currentusersession);
			return currentusersession.toString();
		}else
			throw new LoginException("User already login with this number");
		
	
	}

	@Override
	public String logOutAccount(String key) throws LoginException {
		CustomerUserSession validUserSession=sessionRepo.findByUuid(key);
		if(validUserSession==null) {
			throw new LoginException("User Not logged in with this Number");
		}
		sessionRepo.delete(validUserSession);
		return "Logged out";
	}

}
