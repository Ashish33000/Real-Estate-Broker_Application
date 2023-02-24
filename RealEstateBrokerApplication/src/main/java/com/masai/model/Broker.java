package com.masai.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.PrimaryKeyJoinColumn;
import lombok.Data;

@Data
@Entity
@PrimaryKeyJoinColumn(name="adminId")
public class Broker extends Admin{
//	@Id
//	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer brokId;
	private String broName;
	@OneToMany(mappedBy = "broker",cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	private List<Property> properties=new ArrayList<>();
	@OneToOne
	private Customer customer;
	
}
