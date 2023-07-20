package com.masai.service;

import java.util.List;

import com.masai.exception.PropertyException;
import com.masai.model.Property;
import com.masai.model.PropertyCriteria;

public interface PropertyService {
	
//	public Property saveProperty(Integer brokerId,Property property)throws PropertyException,BrokerException;
//	public Property updateProperty(Integer propId,Property property,Integer brokerId)throws PropertyException,BrokerException;
//	public Property deleteProperty(Integer propId)throws PropertyException;
	public Property viewProperty(Integer propId)throws PropertyException;
	public List<Property> listAllProperty()throws PropertyException;
	public List<Property> listPropertyBycriteria(PropertyCriteria criteria)throws PropertyException;
	
	
	

}
