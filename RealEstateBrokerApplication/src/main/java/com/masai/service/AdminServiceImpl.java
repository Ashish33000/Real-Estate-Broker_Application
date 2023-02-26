package com.masai.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.exception.AdminException;
import com.masai.model.Admin;
import com.masai.model.BrokerAdminSession;
import com.masai.repository.AdminRepository;
import com.masai.repository.BrokerSessionRepository;
@Service
public class AdminServiceImpl implements AdminService {
	@Autowired
   private AdminRepository adminRepo;
	
	@Autowired
	private BrokerSessionRepository adminsessionRepo;

	@Override
	public Admin createAdmin(Admin admin) throws AdminException {
		Admin existingAdmin=adminRepo.findByAdminMobileno(admin.getAdminMobileno());
		if(existingAdmin!=null) {
			throw new AdminException("Admin Already Registered with Mobile n");
		}
		return adminRepo.save(admin);
	}

	@Override
	public Admin updateAdmin(Admin admin, String key) throws AdminException {
		BrokerAdminSession loggInUser=adminsessionRepo.findByUuid(key);
		if(loggInUser==null) {
			throw new AdminException("Please provide valid key to update Admin");
		}
		if(admin.getAdminId()==loggInUser.getAdminId()) {
			return adminRepo.save(admin);
		}else {
			throw new AdminException("Invalid customer Details please LogIn first");
		}
	}
	

}
