package com.masai.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.exception.CustomerException;
import com.masai.exception.LoginException;
import com.masai.model.Customer;
import com.masai.model.CustomerUserSession;
import com.masai.repository.CustomerRepository;
import com.masai.repository.CustomerSessionRepository;
import com.masai.repository.UserRepository;
@Service

public class CustomerServiceImpl implements CustomerService {
	@Autowired
	private CustomerRepository customerRepo;
	
	@Autowired
	private CustomerSessionRepository customersessionRepo;
	
	@Autowired
	private UserRepository  userRepo;

	@Override
	public Customer addCoustomer(Customer customer) throws CustomerException {
		Customer existingcustomer=customerRepo.findByCustName(customer.getCustName());
		if(existingcustomer!=null)
			throw new CustomerException("customer Already Exist");
		else
			
		return customerRepo.save(customer);
	}

	@Override
	public Customer editCoustomer(Customer customer,String key) throws CustomerException,LoginException {
		CustomerUserSession logInUser=customersessionRepo.findByUuid(key);
		if(logInUser.equals(null))throw new LoginException("please provide valid key to update customer");
	if(customer.getCustId()==logInUser.getUserId()) {
		return customerRepo.save(customer);
	}else {
		throw new CustomerException("customer doesnot  Exist");
	}
		
	}

	@Override
	public Customer removeCoustomer(Integer custId, String key) throws CustomerException, LoginException {
		CustomerUserSession logInUser=customersessionRepo.findByUuid(key);
		if(logInUser.equals(null))throw new LoginException("Customer not logged in");
		Optional<Customer> opt=customerRepo.findById(custId);
		if(opt.isPresent()) {
			Customer customer=opt.get();
			customerRepo.delete(customer);
			return customer;
		}else {
			throw new CustomerException("customer not found by customerId"+custId);
		}
		
	}

	@Override
	public Customer viewCoustomer(Integer custId) throws CustomerException {
		Optional<Customer> opt=customerRepo.findById(custId);
		if(opt.isPresent()) {
			return opt.get();
		}else
			throw new CustomerException("customer not found by customerId"+custId);
		
	}

	@Override
	public List<Customer> viewAllCoustomer() throws CustomerException {
		List<Customer> list=customerRepo.findAll();
		if(list.size()==0)
			throw new CustomerException("customer not found ");
		else
		return list;
	}



}
