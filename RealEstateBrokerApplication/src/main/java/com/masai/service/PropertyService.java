package com.masai.service;

import java.util.List;

import com.masai.entity.Property;
import com.masai.entity.PropertyCriteria;
import com.masai.exception.LoginException;
import com.masai.exception.PropertyException;



public interface PropertyService {
	
	public Property saveProperty(Property property)throws LoginException,PropertyException;
	public Property updateProperty(Property property)throws LoginException,PropertyException;
	public Property deleteProperty(Integer propId)throws LoginException,PropertyException;
	public Property viewProperty(Integer propId)throws LoginException,PropertyException;
	public List<Property> listAllProperty()throws PropertyException;
	public List<Property> listPropertyBycriteria(PropertyCriteria criteria)throws PropertyException;
	
	
	

}
