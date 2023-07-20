

package com.masai.model;

import java.time.LocalDate;

import com.masai.dto.Customer;
import com.masai.dto.Property;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity

@Getter
@Setter
@NoArgsConstructor

@ToString
public class Deal {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer dealId;
	private LocalDate dealDate;
	private double dealCost;
	
//	@OneToOne(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
//	@JoinColumn(name="pid")
//	private Customer customer;
//
//	@OneToOne(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
//	@JoinColumn(name="propId")
//	private Property property;
	

	
	
	
	
	


}
