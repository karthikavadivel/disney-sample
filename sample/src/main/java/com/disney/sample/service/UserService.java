package com.disney.sample.service;

import com.disney.sample.domain.User;

public interface UserService {

	User createUser(User inputUser);

	User login(String userName, String password);

	User changePassword(User user, String newPassword);
}
