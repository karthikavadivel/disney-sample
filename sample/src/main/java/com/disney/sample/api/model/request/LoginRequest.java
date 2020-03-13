package com.disney.sample.api.model.request;

import javax.validation.constraints.NotBlank;

import lombok.Getter;
import lombok.Setter;

public class LoginRequest {

	@NotBlank(message = "User Name is required")
	@Getter
	@Setter
	private String userName;

	@NotBlank(message = "Password is required")
	@Getter
	@Setter
	private String password;

}
