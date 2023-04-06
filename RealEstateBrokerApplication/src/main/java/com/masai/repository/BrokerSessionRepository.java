package com.masai.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.masai.entity.BrokerSession;

public interface BrokerSessionRepository  extends JpaRepository<BrokerSession, Integer>{
	public BrokerSession findByUuid(String uuid);

}
