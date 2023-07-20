
package com.masai.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.masai.model.Deal;

public interface DealRepository extends JpaRepository<Deal, Integer> {

}
