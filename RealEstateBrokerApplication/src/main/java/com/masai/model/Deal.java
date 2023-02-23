package com.masai.model;

import java.time.LocalDateTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.Data;

@Entity
@Data
public class Deal {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer dealId;
	private LocalDateTime dealDate;
	private double dealCost;
	@OneToOne
	private Customer customers;
	@OneToOne
	@JsonIgnore
	private Property property;

}
