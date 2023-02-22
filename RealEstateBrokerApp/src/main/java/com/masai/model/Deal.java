package com.masai.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDate;



import org.hibernate.mapping.Property;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
public class Deal {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer dealId;
	@NotNull(message = "Deal date can not be null or blank")
	private LocalDate date;
	@NotNull(message = "Deal cost can not be null or blank")
	private Double dealCost;

	@ManyToOne
	@JsonIgnore
	@JoinColumn(name = "customerId")
	private Customer customerDeals;

	@OneToOne
	@JsonIgnore
	@JoinColumn(name = "propId")
	private Property property;

	@ManyToOne
	@JsonIgnore
	@JoinColumn(name = "brokerId")
	private Broker dealBroker;

}