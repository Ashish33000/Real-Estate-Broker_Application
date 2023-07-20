package com.masai.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.masai.model.Property;



public interface PropertyRepository extends JpaRepository<Property, Integer> {
	public List<Property> findByConfigurationAndOfferTypeAndCityAndOfferCostBetweenOrderByOfferCostAsc(String config,String offer,String city,double minCost,double maxCost);
	
}
