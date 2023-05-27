package com.masai.service;

import java.util.List;

import com.masai.entity.Customer;
import com.masai.entity.Deal;
import com.masai.entity.Property;
import com.masai.exception.PropertyException;




public interface DealService {
	public Deal addDeal(Property property,Customer customer) throws PropertyException;	
	public List<Deal> viewAllDeal();

}
