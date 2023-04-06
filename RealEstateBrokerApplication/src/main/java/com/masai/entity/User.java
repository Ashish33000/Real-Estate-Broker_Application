package com.masai.entity;



import jakarta.persistence.Column;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
@Data
public abstract class User {
	@NotNull(message = "user name Should not be null")
	private String userName;
	@Email
	@NotNull(message = "user Email Should not be null")
	@Column(unique =true )
	private String userEmail;

}
