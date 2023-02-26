package com.masai.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.masai.model.BrokerAdminSession;
@Repository
public interface BrokerSessionRepository  extends JpaRepository<BrokerAdminSession, Integer>{
	public BrokerAdminSession findByUuid(String uuid);

}
