

package com.masai.model;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

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


	@ManyToOne
	private Broker broker;


	
	

}
