package com.masai.service;

import java.util.List;

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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Customer removeCoustomer(Integer custId) throws CustomerException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Customer viewCoustomer(Integer custId) throws CustomerException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Customer> viewAllCoustomer() throws CustomerException {
		// TODO Auto-generated method stub
		return null;
	}

}
