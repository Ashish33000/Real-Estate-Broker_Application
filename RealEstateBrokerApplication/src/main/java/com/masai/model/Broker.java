package com.masai.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;

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
