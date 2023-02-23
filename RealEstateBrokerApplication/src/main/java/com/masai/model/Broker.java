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
@Entity
@Data
public class Broker {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer brokId;
	private String broName;
	@OneToMany(mappedBy = "brokers",cascade = CascadeType.ALL)
	private List<Property> properties=new ArrayList<>();
	@OneToOne
	private Customer cutomer;
}
