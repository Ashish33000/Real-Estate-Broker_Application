package com.masai.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
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
	@Pattern(regexp = "[a-z]{8}", message = "password should be 8 digit")
	private String brokerPassword;

	@OneToMany(mappedBy = "broker", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JsonIgnore
	private List<Property> property;


}
