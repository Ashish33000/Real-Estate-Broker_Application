package com.masai.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.masai.model.Broker;

public interface BrokerRepository extends JpaRepository<Broker, Integer> {
	
	

}
