

package com.masai.model;

import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Entity
@Data
public class Deal {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer dealId;
	private LocalDateTime dealDate;
	private double dealCost;	
	@JsonIgnore
	@OneToOne(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
	private Property property;
	@JsonIgnore
	@OneToOne(fetch = FetchType.EAGER,cascade = CascadeType.ALL,mappedBy = "deal")
	private Customer customer;
	

}
