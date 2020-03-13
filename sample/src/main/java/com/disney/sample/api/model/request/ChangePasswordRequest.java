package com.disney.sample.api.model.request;

import javax.validation.constraints.NotBlank;

import lombok.Getter;
import lombok.Setter;

public class ChangePasswordRequest {

	@NotBlank(message = "User Name is required")
	@Getter
	@Setter
	private String userName;

	@NotBlank(message = "Old Password is required")
	@Getter
	@Setter
	private String oldPassword;

	@NotBlank(message = "New Password is required")
	@Getter
	@Setter
	private String newPassword;
}
