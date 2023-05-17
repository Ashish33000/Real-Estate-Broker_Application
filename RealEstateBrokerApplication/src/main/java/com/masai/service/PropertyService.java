package com.masai.service;

import java.util.List;

import com.masai.entity.Property;
import com.masai.entity.PropertyCriteria;
import com.masai.exception.BrokerException;
import com.masai.exception.LoginException;
import com.masai.exception.PropertyException;



public interface PropertyService {
	
	public Property saveProperty(Integer brokerId,Property property)throws PropertyException,BrokerException;
	public Property updateProperty(Integer propId,Property property,Integer brokerId)throws PropertyException,BrokerException;
	public Property deleteProperty(Integer propId)throws PropertyException;
	public Property viewProperty(Integer propId)throws PropertyException;
	public List<Property> listAllProperty()throws PropertyException;
	public List<Property> listPropertyBycriteria(PropertyCriteria criteria)throws PropertyException;
	
	
	

}
