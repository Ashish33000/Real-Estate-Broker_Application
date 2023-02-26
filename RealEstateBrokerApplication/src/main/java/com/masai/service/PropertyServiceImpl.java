package com.masai.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.exception.LoginException;
import com.masai.exception.PropertyException;
import com.masai.model.BrokerAdminSession;
import com.masai.model.Property;
import com.masai.model.PropertyCriteria;
import com.masai.repository.AdminRepository;
import com.masai.repository.BrokerRepository;
import com.masai.repository.BrokerSessionRepository;
import com.masai.repository.PropertyRepository;
@Service
public class PropertyServiceImpl implements PropertyService {
	@Autowired
	private PropertyRepository  propertyRepo;
	@Autowired
	private BrokerRepository brokerRepo;
	@Autowired
	private BrokerSessionRepository brokersessionRepo;
	@Autowired
	private AdminRepository adminRepo;
	@Autowired
	private BrokerService brokerservice;
	@Override
	
	
	public Property saveProperty(Property property, String key)throws LoginException, PropertyException {
		BrokerAdminSession logInUser=brokersessionRepo.findByUuid(key);
		if(logInUser.equals(null))throw new LoginException("Broker not loggedIn");
		if(!property.getConfiguration().equals("flat")&&!property.getConfiguration().equals("shop") && !property.getConfiguration().equals("plot")) {
			throw new PropertyException("configuration can be plot shop and flat only");
		}
		if(!property.getOfferType().equals("sell")&&!property.getOfferType().equals("rent")) {
			throw new PropertyException("Offertype can be sell and rent only");
		}
		brokerservice.editBroker(property.getBroker(), key);
		property.setStatus(true);
		return propertyRepo.save(property);
	}
	@Override
	public Property updateProperty(Property property, String key)throws  LoginException, PropertyException {
		BrokerAdminSession logInUser=brokersessionRepo.findByUuid(key);
		if(logInUser.equals(null))throw new LoginException("Broker not loggedIn");
		if(!property.getConfiguration().equals("flat")&&!property.getConfiguration().equals("shop") && !property.getConfiguration().equals("plot")) {
			throw new PropertyException("configuration can be plot shop and flat only");
		}
		if(!property.getOfferType().equals("sell")&&!property.getOfferType().equals("rent")) {
			throw new PropertyException("Offertype can be sell and rent only");
		}
		Property Existingproperty=propertyRepo.findById(property.getPropId()).get();
		if(Existingproperty==null) {
			throw new PropertyException("propertyId:"+property.getPropId()+" is Invalid");
		}
		
		return Existingproperty;
	}
	@Override
	public Property deleteProperty(Integer propId, String key) throws  LoginException, PropertyException {
		BrokerAdminSession logInUser=brokersessionRepo.findByUuid(key);
		if(logInUser.equals(null))throw new LoginException("Broker not loggedIn");
		Property property=viewProperty(propId, key);
		propertyRepo.deleteById(propId);
		return property;
	}
	@Override
	public Property viewProperty(Integer propId, String key) throws  LoginException, PropertyException {
		BrokerAdminSession logInUser=brokersessionRepo.findByUuid(key);
		if(logInUser.equals(null))throw new LoginException("Broker not loggedIn");
	    Optional<Property> property=propertyRepo.findById(propId);
         if(property.isEmpty()) 
        	 throw new PropertyException("propertyId:"+propId+" is Invalid");
         else
        	 return property.get();
	}
	@Override
	public List<Property> listAllProperty(String key) throws  LoginException, PropertyException {
		BrokerAdminSession logInUser=brokersessionRepo.findByUuid(key);
		if(logInUser.equals(null))throw new LoginException("Broker not loggedIn");
		 List<Property> list=propertyRepo.findAll();
		 if(list.size()==0) {
			 throw new PropertyException("Propery not exist");
		 }
		return list;
	}
	@Override
	public List<Property> listPropertyBycriteria(PropertyCriteria criteria, String key)
			throws LoginException, PropertyException {
		// TODO Auto-generated method stub
		BrokerAdminSession logInUser=brokersessionRepo.findByUuid(key);
		if(logInUser.equals(null))throw new LoginException("Broker not loggedIn");
		List<Property> list=propertyRepo.findByConfigurationAndOfferTypeAndCityAndOfferCostBetweenOrderByOfferCostAsc(criteria.getConfig(), criteria.getOffer(), criteria.getCity(), criteria.getMinCost(), criteria.getMaxcost());
		if(list.isEmpty()) {
			 throw new PropertyException("Propery Match not found");
		}
		
		
		return list;
	}
	

	
}
