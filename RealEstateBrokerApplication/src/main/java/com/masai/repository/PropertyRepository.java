package com.masai.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.masai.entity.Property;



public interface PropertyRepository extends JpaRepository<Property, Integer> {
	
	
}
