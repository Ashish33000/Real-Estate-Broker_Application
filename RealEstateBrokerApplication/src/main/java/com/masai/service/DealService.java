package com.masai.service;

import java.util.List;

import com.masai.model.Customer;
import com.masai.model.Deal;
import com.masai.model.Property;


public interface DealService {
	public Deal addDeal(Property property,Customer customer);
	
	public List<Deal> viewAllDeal();

}
