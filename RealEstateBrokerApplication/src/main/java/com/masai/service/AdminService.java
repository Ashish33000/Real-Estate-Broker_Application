package com.masai.service;

import com.masai.exception.AdminException;
import com.masai.model.Admin;

public interface AdminService {
	
	public Admin createAdmin(Admin admin) throws AdminException;
	public Admin updateAdmin(Admin admin,String key)throws AdminException;

}
