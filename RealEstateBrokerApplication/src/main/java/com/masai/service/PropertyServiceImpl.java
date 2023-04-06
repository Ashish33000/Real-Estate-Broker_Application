package com.masai.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.masai.exception.LoginException;
import com.masai.exception.PropertyException;
import com.masai.model.Property;
import com.masai.model.PropertyCriteria;
@Service
public class PropertyServiceImpl implements PropertyService {
	
	public Property saveProperty(Property property, String key) throws LoginException, PropertyException {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Property updateProperty(Property property, String key) throws LoginException, PropertyException {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Property deleteProperty(Integer propId, String key) throws LoginException, PropertyException {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Property viewProperty(Integer propId, String key) throws LoginException, PropertyException {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public List<Property> listAllProperty(String key) throws LoginException, PropertyException {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public List<Property> listPropertyBycriteria(PropertyCriteria criteria, String key)
			throws LoginException, PropertyException {
		// TODO Auto-generated method stub
		return null;
	}


	
	

	

	
}
