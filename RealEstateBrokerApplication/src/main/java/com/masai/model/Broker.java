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
import lombok.Data;

@Data
@Entity
public class Broker{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer brokId;
	private String broName;
	@OneToMany(mappedBy = "broker",cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	private List<Property> properties=new ArrayList<>();
	
}
