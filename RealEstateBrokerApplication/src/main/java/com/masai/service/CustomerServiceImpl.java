package com.masai.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.exception.CustomerException;
import com.masai.model.CurrentUserSession;
import com.masai.model.Customer;
import com.masai.repository.CustomerRepository;
import com.masai.repository.SessionRepository;
@Service
public class CustomerServiceImpl implements CustomerService {
	@Autowired
	private CustomerRepository  customerRepo;
	@Autowired
	private SessionRepository sessionRepo;

	@Override
	public Customer createCustomer(Customer customer) throws CustomerException {
		Customer existiongCustomer=customerRepo.findByCustomerMobileNo(customer.getCustomerMobileNo());
		if(existiongCustomer!=null) {
			throw new CustomerException("Customer Already Registered with Mobile n");
		}
		return customerRepo.save(customer);
	}

	@Override
	public Customer updateCustomer(Customer customer, String key) throws CustomerException {
		CurrentUserSession loggInUser=sessionRepo.findByUuid(key);
		if(loggInUser==null) {
			throw new CustomerException("Please provide valid key to update Customer");
		}
		if(customer.getCustomerId()==loggInUser.getUserId()) {
			return customerRepo.save(customer);
		}else {
			throw new CustomerException("Invalid customer Details please LogIn first");
		}
	
	}

}
