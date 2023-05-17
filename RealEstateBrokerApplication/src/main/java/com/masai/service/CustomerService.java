package com.masai.service;

import java.util.List;

import com.masai.entity.Customer;
import com.masai.exception.CustomerException;



public interface CustomerService {
	
	public Customer addCoustomer(Customer customer);
	public Customer editCoustomer(Integer custId,Customer customer) throws CustomerException;
	public Customer removeCoustomer(Integer custId) throws CustomerException;
	public Customer viewCoustomer(Integer custId) throws CustomerException;
	public List<Customer> viewAllCoustomer()throws CustomerException;

}
