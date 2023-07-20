package com.masai.service;

import java.util.List;

import com.masai.dto.Customer;
import com.masai.dto.Property;
import com.masai.exception.PropertyException;
import com.masai.model.Deal;




public interface DealService {
	public Deal addDeal(Property property,Customer customer) throws PropertyException;	
	public List<Deal> viewAllDeal();

}
