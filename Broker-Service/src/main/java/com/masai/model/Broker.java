package com.masai.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Broker {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer brokerId;	
	
	private String name;

	


}
