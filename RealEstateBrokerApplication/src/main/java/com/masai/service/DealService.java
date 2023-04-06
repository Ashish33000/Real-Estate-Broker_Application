package com.masai.service;

import java.util.List;

import com.masai.entity.Customer;
import com.masai.entity.Deal;
import com.masai.entity.Property;




public interface DealService {
	public Deal addDeal(Property property,Customer customer);
	
	public List<Deal> viewAllDeal();

}
