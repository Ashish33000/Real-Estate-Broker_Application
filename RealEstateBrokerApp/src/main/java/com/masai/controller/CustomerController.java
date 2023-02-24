package com.masai.controller;

import com.masai.exception.CustomerException;
import com.masai.model.Customer;
import com.masai.model.Deal;
import com.masai.service.CustomerService;
import com.masai.service.DealException;
import com.masai.service.PropertyException;

import jakarta.validation.Valid;

import org.hibernate.validator.internal.properties.Property;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import javax.security.auth.login.LoginException;

@RestController
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    private CustomerService customerService;
    @PostMapping("/register")
    public ResponseEntity<Customer> registerCustomerHandler(@Valid @RequestBody Customer customer){

       Customer customer1 =  customerService.createCustomer(customer);

       return new ResponseEntity<Customer>(customer1, HttpStatus.CREATED);
    }
    @PutMapping("/update/{key}")
    public ResponseEntity<Customer>updateCustomerHandler(@Valid @RequestBody Customer customer, @PathVariable String key) throws CustomerException, LoginException{

        Customer customer1 =  customerService.updateCustomer(customer,key);

          return new ResponseEntity<Customer>(customer1,HttpStatus.OK);
    }

    @GetMapping("/profile/{key}")
    public ResponseEntity<Customer> getProfileHandler(@PathVariable String key) throws LoginException{

        Customer customer=customerService.getProfile(key);
        return new ResponseEntity<>(customer,HttpStatus.OK);
    }

    @GetMapping("/propertybytype/{key}/{propertytype}")
    public ResponseEntity<List<Property>> getProfileHandler(@PathVariable String key, @PathVariable String propertytype) throws LoginException, PropertyException{

        List<Property> properties=customerService.viewPropertyByPropertyType(key,propertytype);

        return new ResponseEntity<>(properties,HttpStatus.OK);
    }
    @GetMapping("/viewallproperty/{key}")
	public ResponseEntity<List<Property>> viewAllPropertyHandler(@PathVariable String key) throws LoginException, CustomerException, PropertyException{

		List<Property> property1=customerService.viewAllProperty(key);

		return new ResponseEntity<>(property1,HttpStatus.OK);
	}

    @GetMapping("/adddeal/{pid}/{key}")
    public ResponseEntity<Deal> addDeal( @PathVariable Integer pid ,@PathVariable String key) throws LoginException, PropertyException{

        Deal deal = customerService.addDeal(pid, key);

        return new ResponseEntity<>(deal,HttpStatus.CREATED);
    }

    @GetMapping("/getdeals/{key}")
    public ResponseEntity<List<Deal>> getAllDealHandler(@PathVariable String key) throws LoginException, DealException{

          List<Deal> deals = customerService.viewAllDeals(key);

        return new ResponseEntity<>(deals,HttpStatus.OK);
    }
}
