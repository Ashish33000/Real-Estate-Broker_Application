package com.masai.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.exception.UserException;
import com.masai.model.CurrentUserSession;
import com.masai.model.User;
import com.masai.repository.UserRepository;
import com.masai.repository.SessionRepository;
@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserRepository  userRepo;
	@Autowired
	private SessionRepository sessionRepo;

	@Override
	public User createUser(User customer) throws UserException {
		User existiongCustomer=userRepo.findByUserMobileNo(customer.getUserMobileNo());
		if(existiongCustomer!=null) {
			throw new UserException("Customer Already Registered with Mobile n");
		}
		return userRepo.save(customer);
	}

	@Override
	public User updateUser(User user, String key) throws UserException {
		CurrentUserSession loggInUser=sessionRepo.findByUuid(key);
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