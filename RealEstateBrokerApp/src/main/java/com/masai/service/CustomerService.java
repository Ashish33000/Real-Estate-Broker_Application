package com.masai.service;
import com.masai.exception.*;

import com.masai.model.Customer;
import com.masai.model.CustomerCurrentSession;
import com.masai.model.Deal;


import java.util.List;

import javax.security.auth.login.LoginException;

import org.hibernate.mapping.Property;

public interface CustomerService {
    public Customer createCustomer(Customer customer)throws CustomerException;

    public Customer updateCustomer(Customer customer, String key) throws CustomerException,LoginException;

    public Customer getProfile(String key)  throws LoginException;

    public List<Property> viewPropertyByPropertyType(String key, String propertyType) throws PropertyException, LoginException;
    
	public List<Property> viewAllProperty(String key) throws PropertyException,LoginException,CustomerException;

    public Deal addDeal(Integer propid , String key) throws PropertyException,LoginException;

    public List<Deal> viewAllDeals(String key)throws LoginException, DealException;

	public CustomerCurrentSession findByCid(String key);
}
