package com.masai.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.masai.entity.Property;



public interface PropertyRepository extends JpaRepository<Property, Integer> {
	public List<Property> findByConfigurationAndOfferTypeAndCityAndOfferCostBetweenOrderByOfferCostAsc(String config,String offer,String city,double minCost,double maxCost);
	
}
