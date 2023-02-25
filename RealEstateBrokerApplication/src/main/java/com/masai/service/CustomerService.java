package com.masai.service;

import java.util.List;

import com.masai.exception.CustomerException;
import com.masai.exception.LoginException;
import com.masai.model.Customer;

public interface CustomerService {
	
	public Customer addCoustomer(Customer customer) throws CustomerException;
	public Customer editCoustomer(Customer customer,String key) throws CustomerException,LoginException;
	public Customer removeCoustomer(Integer custId,String key) throws CustomerException,LoginException;
	public Customer viewCoustomer(Integer custId) throws CustomerException;
	public List<Customer> viewAllCoustomer()throws CustomerException;

}
