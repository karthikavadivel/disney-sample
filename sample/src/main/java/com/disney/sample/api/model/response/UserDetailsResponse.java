package com.disney.sample.api.model.response;

import lombok.Getter;
import lombok.Setter;

public class UserDetailsResponse {
	@Getter
	@Setter
	private String userName;

	@Getter
	@Setter
	private String firstName;

	@Getter
	@Setter
	private String lastName;
}
