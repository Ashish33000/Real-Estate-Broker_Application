
package com.masai.model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Property {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer propId;

	private String configuration;
	private String offerType;
	private double offerCost;
	private double areaSqft;
	private String address;
	private String street;	
	private String city;
	private boolean status;


//	@ManyToOne(cascade = CascadeType.ALL)
//	@JoinColumn(name="bid")
//	private Broker broker;


	
	

}
