package com.masai.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.masai.entity.Broker;

public interface BrokerRepository extends JpaRepository<Broker, Integer> {
	
	public Broker findByBrokerMobileNo(String brokermobileNo);

}
