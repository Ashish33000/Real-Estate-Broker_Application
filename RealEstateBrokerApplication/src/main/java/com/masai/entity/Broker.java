package com.masai.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Broker {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer brokerId;	

//	@OneToMany(mappedBy = "broker", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
//	@JsonIgnore
//	private List<Property> property;


}
