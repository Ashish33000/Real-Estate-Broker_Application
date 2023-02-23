package com.masai.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.Data;

@Data
@Entity
public class Property {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer propId;
	private String configuration;
	private String offerType;
	private double offerCost;
	private double areaSqft;
	private String address;
	private String street;
	private String city;
	private boolean status;
	private Broker broker;
	@ManyToOne
	@JsonIgnore
	private Customer customers;
	@ManyToOne
	@JsonIgnore
	private Broker brokers;
	@OneToOne(mappedBy = "property",cascade = CascadeType.ALL)
	private Deal deals;
	

}
