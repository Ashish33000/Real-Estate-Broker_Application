package com.masai.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
@Entity
public class Customer {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer customerId;
	@NotNull(message = "admin name Should not be null")
	private String customerName;
	@NotNull(message = "Mobile no Should not be null")
	@Pattern(regexp = "[6,7,8,9]{1}[0-9]{9}",message = "Mobile no should be of 10 digit only")
	private String customerMobileNo;
	@NotNull(message = "Customer Password Should not be null")
	@Size(min = 8,max = 15,message = "Password should be Min 8 character and max 15 character")
	private String customerPassword;
	@Email
	@NotNull(message = "Customer Email Should not be null")
	@Column(unique =true )
	private String customerEmail;

}
