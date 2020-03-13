package com.disney.sample.api.model.request;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;

public class RegisterUserRequest {
	@NotBlank(message = "User Name is required")
	@Size(max = 100, message = "User Name Max Length is 100")
	@Getter
	@Setter
	private String userName;

	@NotBlank(message = "Password is required")
	@Size(max = 20, message = "Password Max Length is 20")
	@Getter
	@Setter
	private String password;

	@NotBlank(message = "First Name is required")
	@Size(max = 50, message = "First Name Max Length is 50")
	@Getter
	@Setter
	private String firstName;

	@Getter
	@Setter
	@Size(max = 50, message = "Last Name Max Length is 50")
	private String lastName;
}
