package com.masai.service;

import java.util.List;

import com.masai.entity.Property;
import com.masai.entity.PropertyCriteria;
import com.masai.exception.LoginException;
import com.masai.exception.PropertyException;



public interface PropertyService {
	
	public Property saveProperty(Property property,String key)throws LoginException,PropertyException;
	public Property updateProperty(Property property,String key)throws LoginException,PropertyException;
	public Property deleteProperty(Integer propId,String key)throws LoginException,PropertyException;
	public Property viewProperty(Integer propId,String key)throws LoginException,PropertyException;
	public List<Property> listAllProperty(String key)throws LoginException,PropertyException;
	public List<Property> listPropertyBycriteria(PropertyCriteria criteria,String key)throws LoginException,PropertyException;
	
	
	

}
