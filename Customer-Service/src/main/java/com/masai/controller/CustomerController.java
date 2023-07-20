package com.masai.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.masai.model.Customer;
import com.masai.service.CustomerService;

@RestController
@RequestMapping("/customer")
@CrossOrigin(origins="*")
public class CustomerController {
	@Autowired
	private CustomerService custSer;
	
	@PostMapping("/addcustomer")
	@ResponseStatus(code = HttpStatus.CREATED)
	public Customer addCoustomer(@RequestBody  Customer customer) {
		return custSer.addCoustomer(customer);
	}
	@PutMapping("/customer/{custId}")
	@ResponseStatus(code = HttpStatus.OK)
	public Customer updateCoustomer(@PathVariable Integer custId,@RequestBody  Customer customer) {
		return custSer.editCoustomer(custId, customer);
	}
	@DeleteMapping("/customer/{custId}")
	@ResponseStatus(code = HttpStatus.OK)
	public Customer deleteCoustomer(@PathVariable  Integer custId) {
		return custSer.removeCoustomer(custId);
	}
	
	@GetMapping("/customer/{custId}")
	@ResponseStatus(code = HttpStatus.OK)
	public Customer viewCoustomerById(@PathVariable  Integer custId) {
		return custSer.viewCoustomer(custId);
	}
	@GetMapping("/customers")
	@ResponseStatus(code = HttpStatus.OK)
	public List<Customer> viewAllCoustomer(){
		return custSer.viewAllCoustomer();
	}
	
	@GetMapping("/hello")
	public String getHello() {
		return "Hello from customer Service";
	}

}
