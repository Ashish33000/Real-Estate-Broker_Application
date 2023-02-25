package com.masai.service;

import java.util.List;

import com.masai.exception.LoginException;
import com.masai.exception.PropertyException;
import com.masai.model.Property;
import com.masai.model.PropertyCriteria;

public interface PropertyService {
	
	public Property saveProperty(Property property,String key)throws LoginException,PropertyException;
	public Property updateProperty(Property property,String key)throws LoginException,PropertyException;
	public Property deleteProperty(Integer propId,String key)throws LoginException,PropertyException;
	public Property fetchProperty(Integer propId,String key)throws LoginException,PropertyException;
	public List<Property> fetchProperty(String key)throws LoginException,PropertyException;
	public List<Property> fetchPropertyBycriteria(PropertyCriteria criteria,String key)throws LoginException,PropertyException;
	
	
	

}
