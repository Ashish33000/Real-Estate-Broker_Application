

package com.masai.model;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class Deal {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer dealId;
	private LocalDateTime dealDate;
	private double dealCost;	
//	@JsonIgnore
//	@OneToOne(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
//	private Property property;
//	@JsonIgnore
//	@OneToOne(fetch = FetchType.EAGER,cascade = CascadeType.ALL,mappedBy = "deal")
//	private Customer customer;
	

}
