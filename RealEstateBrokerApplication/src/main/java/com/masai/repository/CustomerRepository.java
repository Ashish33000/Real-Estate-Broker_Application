package com.masai.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.masai.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {
  public Customer findByCustomerMobileNo(String mobileNo);
}
