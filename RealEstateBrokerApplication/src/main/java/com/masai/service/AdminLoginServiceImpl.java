package com.masai.service;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.exception.LoginException;
import com.masai.model.Admin;
import com.masai.model.CurrentUserSession;
import com.masai.model.LoginDTO;
import com.masai.repository.AdminRepository;
import com.masai.repository.SessionRepository;

import net.bytebuddy.utility.RandomString;
@Service
public class AdminLoginServiceImpl implements AdminLoginService {
	@Autowired
	private AdminRepository adminRepo;
	@Autowired
	private SessionRepository sessionRepo;

	@Override
	public String logIntoAccount(LoginDTO dto) throws LoginException {
		Admin existingAdmin=adminRepo.findByAdminMobileNo(dto.getMobileNo());
		if(existingAdmin==null) {
			throw new LoginException("Please Enter a Valid Mobile no");
		}
		Optional<CurrentUserSession> validAdminSession=sessionRepo.findById(existingAdmin.getAdminId());
		if(validAdminSession.isPresent()) {
			throw new LoginException("Admin already login with this number");
		}
		if(existingAdmin.getAdminPassword().equals(dto.getPassword())) {
			String key=RandomString.make(6);
			
			CurrentUserSession currentusersession=new CurrentUserSession(existingAdmin.getAdminId(),key,LocalDateTime.now());
			sessionRepo.save(currentusersession);
			return currentusersession.toString();
		}else
			throw new LoginException("Admin already login with this number");
		
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
