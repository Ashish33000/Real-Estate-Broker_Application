package com.masai.service;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.exception.LoginException;
import com.masai.model.Admin;
import com.masai.model.AdminLoginDTO;
import com.masai.model.BrokerAdminSession;
import com.masai.repository.AdminRepository;
import com.masai.repository.BrokerSessionRepository;

import net.bytebuddy.utility.RandomString;
@Service
public class AdminLoginServiceImpl implements AdminLoginService {
	@Autowired
	private AdminRepository adminRepo;
	@Autowired
	private BrokerSessionRepository adminsessionRepo;

	@Override
	public String logIntoAccount(AdminLoginDTO dto) throws LoginException {
		Admin existingAdmin=adminRepo.findByAdminMobileno(dto.getAdminmobileNo());
		if(existingAdmin==null) {
			throw new LoginException("Please Enter a Valid Mobile no");
		}
		Optional<BrokerAdminSession> validAdminSession=adminsessionRepo.findById(existingAdmin.getAdminId());
		if(validAdminSession.isPresent()) {
			throw new LoginException("Admin already login with this number");
		}
		if(existingAdmin.getAdminPassword().equals(dto.getAdminmobileNo())) {
			String key=RandomString.make(6);
			
			BrokerAdminSession currentusersession=new BrokerAdminSession(existingAdmin.getAdminId(),key,LocalDateTime.now());
			adminsessionRepo.save(currentusersession);
			return currentusersession.toString();
		}else
			throw new LoginException("Admin already login with this number");
		
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
