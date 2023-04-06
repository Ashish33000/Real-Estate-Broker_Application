package com.masai.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.masai.entity.CustomerSession;

public interface CustomerSessionRepository  extends JpaRepository<CustomerSession, Integer>{
	public CustomerSession findByUuid(String uuid);

}
