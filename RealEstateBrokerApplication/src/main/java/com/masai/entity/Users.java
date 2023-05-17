package com.masai.entity;



import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
@Data
@Entity
public  class Users {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer userId;
	@NotNull(message = "user name Should not be null")
	private String userName;
	@Email
//	@NotNull(message = "user Email Should not be null")
	@Column(unique =true )
	private String userEmail;
//	@NotNull
//	@Pattern(regexp = "[0-9]{8}", message = "password should be 8 digit")
	@JsonProperty(access = Access.WRITE_ONLY)
	private String userPassword;
	@NotNull(message = "Mobile no Should not be null")
	@Pattern(regexp = "[6-9]{1}[0-9]{9}", message = "Mobile no should be of 10 digit only")
	private String userMobileNo;
	private String role;
	
	
	

}
