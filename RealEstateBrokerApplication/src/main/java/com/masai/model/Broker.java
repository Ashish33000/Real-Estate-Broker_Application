package com.masai.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Data
@Entity
public class Broker extends User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer brokerId;
	@NotNull(message = "Mobile no Should not be null")
	@Pattern(regexp = "[6-9]{1}[0-9]{9}", message = "Mobile no should be of 10 digit only")
	private String brokerMobileNo;
	@NotNull
	@Pattern(regexp = "[a-z]", message = "password should be 8 digit")
	private String brokerPassword;

	@OneToMany(mappedBy = "broker", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JsonIgnore
	private List<Property> properties;


}
