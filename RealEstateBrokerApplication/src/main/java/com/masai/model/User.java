package com.masai.model;

import javax.persistence.Column;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

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
