package com.masai.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.Data;

@Data
@Entity
public class Customer {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer custId;
	private String custName;
	@OneToMany(mappedBy = "customers",cascade = CascadeType.ALL)
	private List<Property> properties=new ArrayList<>();
	@OneToOne(mappedBy = "customers",cascade = CascadeType.ALL)
	private Deal deal;
	@OneToOne
	private Broker broker;

}
