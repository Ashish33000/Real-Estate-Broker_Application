package com.masai.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import lombok.Data;

@Data
@Entity
public class Customer extends User{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer custId;
	@NotNull(message = "Mobile no Should not be null")
	@Pattern(regexp = "[6-9]{1}[0-9]{9}", message = "Mobile no should be of 10 digit only")
	private String customerMobileNo;
	@NotNull
	@Pattern(regexp = "[a-z]", message = "password should be 8 digit")
	private String customerPassword;
//	@JsonIgnore
//	@OneToMany(mappedBy = "customers",cascade = CascadeType.ALL)
//	private List<Property> properties;
//	@JsonIgnore
//	@OneToOne
//	private Deal deal;
//	@JsonIgnore
//	@OneToOne(fetch = FetchType.EAGER,cascade = CascadeType.ALL,mappedBy = "customer")
//	private Broker broker;
	

}
