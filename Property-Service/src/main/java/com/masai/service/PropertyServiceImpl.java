package com.masai.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.exception.PropertyException;
import com.masai.model.Property;
import com.masai.model.PropertyCriteria;
import com.masai.repo.PropertyRepository;




@Service
public class PropertyServiceImpl implements PropertyService {
	@Autowired
	private PropertyRepository propertyRepo;
	
	

//	@Override
//	public Property saveProperty(Integer brokerId,Property property) throws PropertyException,BrokerException {
//		Optional<Broker> opt=brokerRepo.findById(brokerId);
//		if(opt.isEmpty()) {
//			throw new BrokerException("No broker Exist from this brokerId: "+brokerId);
//		}
//		Broker broker=opt.get();
//		property.setBroker(broker);
//		propertyRepo.save(property);
//		return property;
//	}
//
//	@Override
//	public Property updateProperty(Integer propId, Property property,Integer brokerId) throws PropertyException,BrokerException {
//		Optional<Broker> opt1=brokerRepo.findById(brokerId);
//		if(opt1.isEmpty()) {
//			throw new BrokerException("No broker Exist from this brokerId: "+brokerId);
//		}
//		Broker broker=opt1.get();
//		Optional<Property> opt=propertyRepo.findById(propId);
//		if(opt.isEmpty()) {
//			throw new PropertyException("property not exist");
//		}else {
//			Property property1=opt.get();
//			property1.setAddress(property.getAddress());
//			property1.setAreaSqft(property.getAreaSqft());
//			property1.setCity(property.getCity());
//			property1.setOfferType(property.getOfferType());
//			property1.setOfferCost(property.getOfferCost());
//			property1.setStatus(property.isStatus());
//			property1.setStreet(property.getStreet());
//			property1.setConfiguration(property.getConfiguration());
//			property1.setBroker(broker);
//			propertyRepo.save(property1);
//			return property1;
//		}
//		
//	}
//
//	@Override
//	public Property deleteProperty(Integer propId) throws PropertyException {
//		Optional<Property> opt=propertyRepo.findById(propId);
//		if(opt.isEmpty()) {
//			throw new PropertyException("property Already Exist with this Id");
//		}else {
//			Property property=opt.get();
//			propertyRepo.delete(property);
//			return property;
//		}
//		
//	}

	@Override
	public Property viewProperty(Integer propId) throws PropertyException {
		
		return propertyRepo.findById(propId).orElseThrow(()->new PropertyException("property Already Exist with this Id"));
	}

	@Override
	public List<Property> listAllProperty() throws PropertyException {
		List<Property> list=propertyRepo.findAll();
		if(list.isEmpty()) throw new PropertyException("property not Exist");
		return list;
	}

	@Override
	public List<Property> listPropertyBycriteria(PropertyCriteria criteria) throws PropertyException {
		List<Property> list=propertyRepo.findByConfigurationAndOfferTypeAndCityAndOfferCostBetweenOrderByOfferCostAsc(criteria.getConfig(), criteria.getOffer(), criteria.getCity(), criteria.getMinCost(), criteria.getMaxcost());
		if(list.isEmpty()) throw new PropertyException("property not Exist by This criteria");
		return list;
	}


	
	

	

	
}
