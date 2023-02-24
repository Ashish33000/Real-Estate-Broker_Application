package com.masai.repository;


import com.masai.model.CustomerCurrentSession;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerSessionDao extends JpaRepository<CustomerCurrentSession,Integer> {
    public CustomerCurrentSession findByCid(String cid);
}

