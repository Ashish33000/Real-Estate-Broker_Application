package com.masai.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Customer{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer custId;	
	private String name;
	
//	@OneToMany( cascade = CascadeType.ALL, fetch = FetchType.EAGER)
//	@JoinColumn(name="cid")
//	private List<Property> properties;


}
