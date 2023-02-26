package com.masai.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.validation.constraints.NotBlank;

import lombok.Data;

@Data
@Entity
@PrimaryKeyJoinColumn(name="")

public class Customer extends User{
//	@Id
//	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer custId;
	@NotBlank(message = "Customer name cannot be blanck")
	private String custName;
	@OneToMany(mappedBy = "customers",cascade = CascadeType.ALL)
	private List<Property> properties=new ArrayList<>();
	@OneToOne
	private Deal deal;
	
	@OneToOne(fetch = FetchType.EAGER,cascade = CascadeType.ALL,mappedBy = "customer")
	private Broker broker;
	

}
