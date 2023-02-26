package com.masai.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Admin {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer adminId;
	@NotNull(message = "admin name Should not be null")
	private String adminName;
	@NotNull(message = "Mobile no Should not be null")
	@Pattern(regexp = "[6,7,8,9]{1}[0-9]{9}",message = "Mobile no should be of 10 digit only")
	private String adminMobileno;
	@NotNull(message = "Admin Password Should not be null")
	@Size(min = 8,max = 15,message = "Password should be Min 8 character and max 15 character")
	private String adminPassword;
	@Email
	@NotNull(message = "Admin Email Should not be null")
	@Column(unique =true )
	private String adminEmail;

}
