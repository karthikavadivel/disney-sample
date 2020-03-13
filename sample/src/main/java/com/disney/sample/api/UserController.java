package com.disney.sample.api;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.disney.sample.api.model.request.ChangePasswordRequest;
import com.disney.sample.api.model.request.LoginRequest;
import com.disney.sample.api.model.request.RegisterUserRequest;
import com.disney.sample.api.model.response.UserDetailsResponse;
import com.disney.sample.domain.User;
import com.disney.sample.exception.BusinessException;
import com.disney.sample.service.UserService;

@RestController
@RequestMapping(path = "/users")
public class UserController {
	private final Logger log = LoggerFactory.getLogger(getClass());

	@Autowired
	private ConversionService conversionService;

	@Autowired
	private UserService userService;

	@PostMapping(path = "/registration", consumes = "application/json", produces = "application/json")
	@ResponseStatus(HttpStatus.CREATED)
	public UserDetailsResponse createUser(@RequestBody @Valid RegisterUserRequest inputUser) {
		var savedUser = userService.createUser(conversionService.convert(inputUser, User.class));

		return conversionService.convert(savedUser, UserDetailsResponse.class);
	}

	@PostMapping(path = "/login", consumes = "application/json", produces = "application/json")
	@ResponseStatus(HttpStatus.OK)
	public UserDetailsResponse login(@RequestBody @Valid LoginRequest loginDto) {
		var user = userService.login(loginDto.getUserName(), loginDto.getPassword());
		log.info("Login Attempt of user {} was successful.", loginDto.getUserName());

		return conversionService.convert(user, UserDetailsResponse.class);
	}

	@GetMapping(path = "/{userId}", produces = "application/json")
	@ResponseStatus(HttpStatus.FOUND)
	public UserDetailsResponse getUserById(@PathVariable("userId") User user) {
		return conversionService.convert(user, UserDetailsResponse.class);
	}

	@PatchMapping(path = "/changePassword", consumes = "application/json", produces = "application/json")
	@ResponseStatus(HttpStatus.OK)
	public UserDetailsResponse changePassword(@RequestBody @Valid ChangePasswordRequest loginDto) {
		validatePasswordChange(loginDto);

		var user = userService.login(loginDto.getUserName(), loginDto.getOldPassword());

		// Ideally as a part of authentication when login service is through, the
		// authentication key will be returned and will be used for all further
		// requests.
		// When that is included, This change-password flow will change accordingly
		log.info("User validation was successful for {}", loginDto.getUserName());

		var updatedUser = userService.changePassword(user, loginDto.getNewPassword());

		return conversionService.convert(updatedUser, UserDetailsResponse.class);
	}

	private void validatePasswordChange(ChangePasswordRequest loginDto) {
		if (loginDto.getOldPassword().equals(loginDto.getNewPassword())) {
			throw new BusinessException("New and Old Passwords are same");
		}
	}
}
