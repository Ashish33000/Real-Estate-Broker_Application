package com.masai.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.masai.exception.CustomerException;
import com.masai.model.Customer;
import com.masai.service.CustomerService;

@RestController
public class CustomerController {
	@Autowired
	private CustomerService customerservice;
	@PostMapping("/customers")
	public ResponseEntity<Customer> saveCustomerHandler(@RequestBody Customer customer) throws CustomerException{
		return new ResponseEntity<Customer>(customerservice.createCustomer(customer),HttpStatus.CREATED);
	}
	@PutMapping("/customers")
	public ResponseEntity<Customer> updateCustomerHandler(@RequestBody Customer customer,@RequestParam(required = false) String key) throws CustomerException{
		return new ResponseEntity<Customer>(customerservice.updateCustomer(customer, key),HttpStatus.CREATED);
	}

}
