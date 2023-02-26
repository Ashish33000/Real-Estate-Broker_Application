package com.masai.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.exception.UserException;
import com.masai.model.CustomerUserSession;
import com.masai.model.User;
import com.masai.repository.CustomerSessionRepository;
import com.masai.repository.UserRepository;
@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserRepository  userRepo;
	@Autowired
	private CustomerSessionRepository sessionRepo;

	@Override
	public User createUser(User user) throws UserException {
		User existiongUser=userRepo.findByUserMobileno(user.getUserMobileno());
		if(existiongUser!=null) {
			throw new UserException("Customer Already Registered with Mobile n");
		}
		return userRepo.save(user);
	}

	@Override
	public User updateUser(User user, String key) throws UserException {
		CustomerUserSession loggInUser=sessionRepo.findByUuid(key);
		if(loggInUser==null) {
			throw new UserException("Please provide valid key to update Customer");
		}
		if(user.getUserId()==loggInUser.getUserId()) {
			return userRepo.save(user);
		}else {
			throw new UserException("Invalid customer Details please LogIn first");
		}
	
	}

}
