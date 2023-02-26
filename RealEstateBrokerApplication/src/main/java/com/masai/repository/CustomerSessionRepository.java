package com.masai.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.masai.model.CustomerUserSession;
@Repository
public interface CustomerSessionRepository  extends JpaRepository<CustomerUserSession, Integer>{
	public CustomerUserSession findByUuid(String uuid);

}
