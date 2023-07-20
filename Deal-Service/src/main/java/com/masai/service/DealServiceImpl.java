package com.masai.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.dto.Customer;
import com.masai.dto.Property;
import com.masai.exception.PropertyException;
import com.masai.model.Deal;
import com.masai.repo.DealRepository;

@Service
public class DealServiceImpl implements DealService {
	@Autowired
	private DealRepository dealRepo;

	@Override
	public Deal addDeal(Property property,Customer customer) throws PropertyException {
//		if(!property.isStatus()) {
//			throw new PropertyException("property Already Sold to customer with propertyid: "+property.getPropId());
//		}else {
//			Deal deal=new Deal(LocalDate.now(),property.getOfferCost(),customer,property);
//			Deal deal1=dealRepo.save(deal);
//			customer.getProperties().add(property);
//			property.setStatus(false);
//			return deal1;
//			
//		}
			return null;
	
	}

	@Override
	public List<Deal> viewAllDeal() {
		// TODO Auto-generated method stub
		return null;
	}

}
