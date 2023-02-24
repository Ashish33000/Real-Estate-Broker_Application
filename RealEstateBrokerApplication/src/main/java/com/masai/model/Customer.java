package com.masai.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.validation.constraints.NotBlank;
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
