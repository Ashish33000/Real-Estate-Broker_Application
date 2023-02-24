package com.masai.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.exception.CustomerException;
import com.masai.model.Customer;
import com.masai.repository.CustomerRepository;
@Service

public class CustomerServiceImpl implements CustomerService {
	@Autowired
	private CustomerRepository customerRepo;

	@Override
	public Customer addCoustomer(Customer customer) throws CustomerException {
		Customer existingcustomer=customerRepo.findByCustName(customer.getCustName());
		if(existingcustomer!=null)
			throw new CustomerException("customer Already Exist");
		else
			
		return customerRepo.save(customer);
	}

	@Override
	public Customer editCoustomer(Customer customer) throws CustomerException {
	if(customer!=null) {
		return customerRepo.save(customer);
	}else {
		throw new CustomerException("customer doesnot  Exist");
	}
		
	}

	@Override
	public Customer removeCoustomer(Integer custId) throws CustomerException {
	    Optional<Customer> customer =customerRepo.findById(custId);
	    if(customer.isEmpty())
	    	throw new CustomerException("customer doesnot  Exist with Id"+custId);
	    customerRepo.delete(customer.get());
		return customer.get();
	}

	@Override
	public Customer viewCoustomer(Integer custId) throws CustomerException {
		 Optional<Customer> customer =customerRepo.findById(custId);
		 if(customer.isPresent())
		      return customer.get();
		 else
			 throw new CustomerException("customer doesnot  Exist with Id"+custId);
	}

	@Override
	public List<Customer> viewAllCoustomer() throws CustomerException {
		List<Customer> customers=customerRepo.findAll();
		return customers;
	}

}
