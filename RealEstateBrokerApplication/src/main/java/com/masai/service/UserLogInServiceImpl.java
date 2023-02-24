package com.masai.service;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.exception.LoginException;
import com.masai.model.CurrentUserSession;
import com.masai.model.User;
import com.masai.model.LoginDTO;
import com.masai.repository.UserRepository;
import com.masai.repository.SessionRepository;

import net.bytebuddy.utility.RandomString;
@Service
public class UserLogInServiceImpl implements LoginService {
	@Autowired
	private UserRepository  userRepo;
	@Autowired
	private SessionRepository sessionRepo;

	@Override
	public String logIntoAccount(LoginDTO dto) throws LoginException {
		User existiongUser=userRepo.findByUserMobileNo(dto.getMobileNo());
		if(existiongUser==null) {
			throw new LoginException("Please Enter a Valid Mobile no");
		}
		Optional<CurrentUserSession> validCustomerSession=sessionRepo.findById(existiongUser.getUserId());
		if(validCustomerSession.isPresent()) {
			throw new LoginException("User already login with this number");
		}
		if(existiongUser.getUserPassword().equals(dto.getPassword())) {
			String key=RandomString.make(6);
			
			CurrentUserSession currentusersession=new CurrentUserSession(existiongUser.getUserId(),key,LocalDateTime.now());
			sessionRepo.save(currentusersession);
			return currentusersession.toString();
		}else
			throw new LoginException("User already login with this number");
		
	
	}

	@Override
	public String logOutAccount(String key) throws LoginException {
		CurrentUserSession validUserSession=sessionRepo.findByUuid(key);
		if(validUserSession==null) {
			throw new LoginException("User Not logged in with this Number");
		}
		sessionRepo.delete(validUserSession);
		return "Logged out";
	}

}
